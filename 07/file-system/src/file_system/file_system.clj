(ns file-system.file-system
  (:gen-class))

(def folder-type "folder")
(def file-type "file")
(defrecord Folder [name children parent type])

(defn create-folder [name children parent]
  (->Folder name children parent folder-type))

(defn add-child [folder child]
  (let [current-children (.children folder)
    updated-children (conj current-children child)
  ] (map->Folder (merge folder {:children  updated-children}))))


(defrecord File [name size parent type])

(defn create-file [name size parent]
  (->File name size parent file-type))
