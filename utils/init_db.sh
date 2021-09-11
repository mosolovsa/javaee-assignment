#!/bin/bash
#psql postgresql://<user>:<password>@<host>/<db> << EOF
psql postgresql://postgres:postgres@localhost:5432 << EOF
       CREATE TABLE IF NOT EXISTS todos(
          id             SERIAL PRIMARY KEY    NOT NULL,
          name           TEXT                      NOT NULL,
          body           TEXT                      NOT NULL,
          created        TEXT                      NOT NULL,
          deadline       TEXT
       );
       INSERT INTO todos (name, body, created)
                   VALUES ('Todo 1', 'Do first thing...', '2001-07-13 17:43:31 GMT+4');
       INSERT INTO todos (name, body, created)
                   VALUES ('Todo 2', 'Do the rest...', '2002-07-13 17:43:31 GMT+4');
EOF
