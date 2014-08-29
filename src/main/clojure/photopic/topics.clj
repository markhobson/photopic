(ns photopic.topics
  (:use
    photopic.support.clostache
  )
)

(defn topics-response []
  (render-page "topics"
    {:topic [
      {:name "Apple"}
      {:name "Banana"}
      {:name "Carrot"}
    ]}
    [:navbar]
  )
)

(defn topic-create-form-response []
  (render-page "topic-create"
    {:topic {}}
    [:navbar]
  )
)
