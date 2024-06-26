/*
 * This file is generated by jOOQ.
 */

package edu.java.scrapper.core.dao.jooq.generated;

import edu.java.scrapper.core.dao.jooq.generated.tables.Chats;
import edu.java.scrapper.core.dao.jooq.generated.tables.Links;
import javax.annotation.processing.Generated;
import org.jooq.Index;
import org.jooq.OrderField;
import org.jooq.impl.DSL;
import org.jooq.impl.Internal;

/**
 * A class modelling indexes of tables in the default schema.
 */
@Generated(
    value = {
        "https://www.jooq.org",
        "jOOQ version:3.17.4"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({"all", "unchecked", "rawtypes"})
public class Indexes {

    // -------------------------------------------------------------------------
    // INDEX definitions
    // -------------------------------------------------------------------------

    public static final Index INDEX_CHATS_TG_CHAT_ID = Internal.createIndex(
        DSL.name("INDEX_CHATS_TG_CHAT_ID"),
        Chats.CHATS,
        new OrderField[] {Chats.CHATS.TG_CHAT_ID},
        false
    );
    public static final Index INDEX_LINKS_VALUE =
        Internal.createIndex(DSL.name("INDEX_LINKS_VALUE"), Links.LINKS, new OrderField[] {Links.LINKS.VALUE}, false);
}
