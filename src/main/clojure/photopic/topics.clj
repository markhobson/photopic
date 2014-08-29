(ns photopic.topics
  (:use
    photopic.support.clostache
    ring.util.response
  )
)

(defn topics-response []
  (render-page "topics"
    {:topic [
      {:name "Apple"}
      {:name "Banana"}
      {:name "Carrot"}
    ]}
    [:head :navbar]
  )
)

(defn topic-create-form-response []
  (render-page "topic-create"
    {:topic {}}
    [:head :navbar]
  )
)

(defn topic-create-response []
  (redirect "/topics")
)