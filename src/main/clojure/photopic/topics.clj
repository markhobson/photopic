(ns photopic.topics
  (:use
    clostache.parser
  )
)

(defn topics-response []
  (render-resource "templates/topics.mustache" {
    :topic [
      {:name "Apple"}
      {:name "Banana"}
      {:name "Carrot"}
    ]
  })
)

(defn topic-create-form-response []
  (render-resource "templates/topic-create.mustache" {
    :topic {}
  })
)
