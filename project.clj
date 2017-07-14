(defproject io.weft/gregor "0.6.0-SNAPSHOT"
  :min-lein-version "2.0.0"
  :description "Lightweight Clojure bindings for Kafka 0.9+"
  :url "https://github.com/weftio/gregor.git"
  :license {:name "Eclipse Public License"
            :url  "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.8.0"]
                 [org.apache.kafka/kafka_2.11 "0.11.0.0"]]
  :plugins [[s3-wagon-private "1.1.2"]
            [lein-codox "0.10.3"]]
  :codox {:output-path "doc"}
  :deploy-repositories {"clojars" {:url           "https://clojars.org/repo"
                                   :sign-releases false
                                   :username      :env
                                   :passphrase    :env}}
  :release-tasks [["vcs" "assert-committed"]
                  ["change" "version" "leiningen.release/bump-version" "release"]
                  ["vcs" "commit"]
                  ["vcs" "tag" "v" "--no-sign"]
                  ["deploy" "clojars"]
                  ["change" "version" "leiningen.release/bump-version"]
                  ["vcs" "commit"]
                  ["vcs" "push" "--no-verify"]])
