(ns file-system.file-system
  (:gen-class))

(def folder-type "folder")
(def file-type "file")
(defrecord Folder [path type])
(defrecord File [path size type])

(defn create-folder [path]
  (->Folder path folder-type))

(defn create-file [size path]
  (->File path size file-type))

(def empty-file-system
  (hash-map '("/") (create-folder '("/"))))

(defn add-folder [file-system path]
  (merge file-system (hash-map path (create-folder path))))

(defn add-file [file-system path size]
  (merge file-system (hash-map path (create-file size path))))



