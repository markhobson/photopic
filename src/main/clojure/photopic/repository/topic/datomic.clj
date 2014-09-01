(ns photopic.repository.topic.datomic
  (:use
    clojure.java.io
  )
  (:require
    [datomic.api :as d]
  )
)

; TODO: move database and schema creation elsewhere 
(def uri "datomic:mem://photopic")
(d/create-database uri)
(def connection (d/connect uri))
@(d/transact connection (read-string (slurp (resource "schema/photopic.edn"))))

(defn- dehydrate [model]
  {:db/id (get model :id)
    :topic/name (get model :name)
  }
)

(defn- rehydrate [entity]
  {:id (get entity :db/id)
    :name (get entity :topic/name)
  }
)

(defn get-all []
  (let [database (d/db connection)]
    (map
      (comp rehydrate #(d/entity database %) first)
      (d/q '[:find ?e :where [?e :topic/name]] database)
    )
  )
)

(defn store [topic]
  @(d/transact connection [
    (conj (dehydrate topic) [:db/id #db/id[:db.part/user]])
  ])
)

(defn delete [id]
  @(d/transact connection [
    [:db.fn/retractEntity id]
  ])
)
