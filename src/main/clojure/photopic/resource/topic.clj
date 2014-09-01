(ns photopic.resource.topic
  (:use
    photopic.support.clostache
    ring.util.response
  )
  (:require
    [photopic.repository.topic :as repository]
  )
)

(defn get-all []
  (let [topics (repository/get-all)]
    (render-page "topic/topics"
      {:topic topics
        :has-topics (boolean (not-empty topics))
      }
      [:head :navbar]
    )
  )
)

(defn create-form []
  (render-page "topic/create"
    {:topic {}}
    [:head :navbar]
  )
)

(defn create [topic]
  (repository/store topic)
  (redirect "/topics")
)

(defn delete [id]
  (repository/delete id)
  (redirect "/topics")
)