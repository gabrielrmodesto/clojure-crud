(ns todo.query
    (:require [todo.database]
              [korma.core :refer :all]))

(defentity items)

;;reading items from db
(defn get-todos []
    (select items))

;;inserting items on db
(defn add-todo [title description]
    (insert items
            (values {:title title :description description})))

