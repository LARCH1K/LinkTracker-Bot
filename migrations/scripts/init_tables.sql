BEGIN;

CREATE TABLE IF NOT EXISTS chats
(
    id        BIGSERIAL PRIMARY KEY,
    createdBy VARCHAR(50) NOT NULL
);

CREATE TABLE IF NOT EXISTS links
(
    id      BIGSERIAL PRIMARY KEY,
    value   VARCHAR(400) NOT NULL,
    hashsum INT
);

CREATE TABLE IF NOT EXISTS chat_links
(
    id      BIGSERIAL PRIMARY KEY,
    chat_id BIGINT REFERENCES chats(id),
    link_id BIGINT REFERENCES links(id)
);

COMMIT;
