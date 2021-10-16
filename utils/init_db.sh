#!/bin/bash
#psql postgresql://<user>:<password>@<host>/<db> << EOF
psql postgresql://postgres:postgres@localhost:5432 << EOF
       DROP TABLE IF EXISTS stores;
       CREATE TABLE stores(
          id             SERIAL PRIMARY KEY    NOT NULL,
          name           VARCHAR(64)           NOT NULL
       );
       INSERT INTO stores (name) VALUES ('Fred Perry');
       INSERT INTO stores (name) VALUES ('Burrberry');
       INSERT INTO stores (name) VALUES ('Lacoste');

       DROP TABLE IF EXISTS malls;
       CREATE TABLE malls(
          id             SERIAL PRIMARY KEY    NOT NULL,
          name           VARCHAR(64)           NOT NULL,
          address        VARCHAR(255)          NOT NULL
       );
       INSERT INTO malls (name, address) VALUES ('Detskiy mir', 'Moscow');
       INSERT INTO malls (name, address) VALUES ('Clockwork orange', 'Samara');

       DROP TABLE IF EXISTS relations;
       CREATE TABLE relations(
          mall_id         BIGINT                NOT NULL,
          store_id        BIGINT                NOT NULL
       );
       INSERT INTO relations (mall_id, store_id) VALUES (1, 1);
       INSERT INTO relations (mall_id, store_id) VALUES (1, 3);
       INSERT INTO relations (mall_id, store_id) VALUES (2, 1);
       INSERT INTO relations (mall_id, store_id) VALUES (2, 2);
EOF
