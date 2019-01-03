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

;;deleting items from db
(defn delete-todo [id]
    (delete items
        (where {:id [= id]})))

;;update items on db
(defn update-todo [id title is-complete]
    (update items
        (set-fields {:title title
                     :is-complete is-complete})
        (where {:id [= id]})))

;;select an especific item from db
(defn get-todo [id]
    (first
        (select items
            (where {:id [= id]}))))