/*
 * This file is generated by jOOQ.
 */

package edu.java.scrapper.core.dao.jooq.generated.tables;

import edu.java.scrapper.core.dao.jooq.generated.DefaultSchema;
import edu.java.scrapper.core.dao.jooq.generated.Keys;
import edu.java.scrapper.core.dao.jooq.generated.tables.records.ChatLinksRecord;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import javax.annotation.processing.Generated;
import org.jetbrains.annotations.NotNull;
import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Function4;
import org.jooq.Identity;
import org.jooq.Name;
import org.jooq.Record;
import org.jooq.Records;
import org.jooq.Row4;
import org.jooq.Schema;
import org.jooq.SelectField;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.TableOptions;
import org.jooq.UniqueKey;
import org.jooq.impl.DSL;
import org.jooq.impl.SQLDataType;
import org.jooq.impl.TableImpl;

/**
 * This class is generated by jOOQ.
 */
@Generated(
    value = {
        "https://www.jooq.org",
        "jOOQ version:3.17.4"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({"all", "unchecked", "rawtypes"})
public class ChatLinks extends TableImpl<ChatLinksRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * The reference instance of <code>CHAT_LINKS</code>
     */
    public static final ChatLinks CHAT_LINKS = new ChatLinks();

    /**
     * The class holding records for this type
     */
    @Override
    @NotNull
    public Class<ChatLinksRecord> getRecordType() {
        return ChatLinksRecord.class;
    }

    /**
     * The column <code>CHAT_LINKS.ID</code>.
     */
    public final TableField<ChatLinksRecord, Long> ID =
        createField(DSL.name("ID"), SQLDataType.BIGINT.nullable(false).identity(true), this, "");

    /**
     * The column <code>CHAT_LINKS.CHAT_ID</code>.
     */
    public final TableField<ChatLinksRecord, Long> CHAT_ID =
        createField(DSL.name("CHAT_ID"), SQLDataType.BIGINT, this, "");

    /**
     * The column <code>CHAT_LINKS.LINK_ID</code>.
     */
    public final TableField<ChatLinksRecord, Long> LINK_ID =
        createField(DSL.name("LINK_ID"), SQLDataType.BIGINT, this, "");

    /**
     * The column <code>CHAT_LINKS.SHORT_NAME</code>.
     */
    public final TableField<ChatLinksRecord, String> SHORT_NAME = createField(
        DSL.name("SHORT_NAME"),
        SQLDataType.VARCHAR(40).nullable(false).defaultValue(DSL.field("'Your link'", SQLDataType.VARCHAR)),
        this,
        ""
    );

    private ChatLinks(Name alias, Table<ChatLinksRecord> aliased) {
        this(alias, aliased, null);
    }

    private ChatLinks(Name alias, Table<ChatLinksRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""), TableOptions.table());
    }

    /**
     * Create an aliased <code>CHAT_LINKS</code> table reference
     */
    public ChatLinks(String alias) {
        this(DSL.name(alias), CHAT_LINKS);
    }

    /**
     * Create an aliased <code>CHAT_LINKS</code> table reference
     */
    public ChatLinks(Name alias) {
        this(alias, CHAT_LINKS);
    }

    /**
     * Create a <code>CHAT_LINKS</code> table reference
     */
    public ChatLinks() {
        this(DSL.name("CHAT_LINKS"), null);
    }

    public <O extends Record> ChatLinks(Table<O> child, ForeignKey<O, ChatLinksRecord> key) {
        super(child, key, CHAT_LINKS);
    }

    @Override
    @NotNull
    public Schema getSchema() {
        return aliased() ? null : DefaultSchema.DEFAULT_SCHEMA;
    }

    @Override
    @NotNull
    public Identity<ChatLinksRecord, Long> getIdentity() {
        return (Identity<ChatLinksRecord, Long>) super.getIdentity();
    }

    @Override
    @NotNull
    public UniqueKey<ChatLinksRecord> getPrimaryKey() {
        return Keys.CONSTRAINT_49;
    }

    @Override
    @NotNull
    public List<UniqueKey<ChatLinksRecord>> getUniqueKeys() {
        return Arrays.asList(Keys.UNIQUE_ID_PAIR);
    }

    @Override
    @NotNull
    public List<ForeignKey<ChatLinksRecord, ?>> getReferences() {
        return Arrays.asList(Keys.CONSTRAINT_49D, Keys.CONSTRAINT_49D6);
    }

    private transient Chats _chats;
    private transient Links _links;

    /**
     * Get the implicit join path to the <code>PUBLIC.CHATS</code> table.
     */
    public Chats chats() {
        if (_chats == null) {
            _chats = new Chats(this, Keys.CONSTRAINT_49D);
        }

        return _chats;
    }

    /**
     * Get the implicit join path to the <code>PUBLIC.LINKS</code> table.
     */
    public Links links() {
        if (_links == null) {
            _links = new Links(this, Keys.CONSTRAINT_49D6);
        }

        return _links;
    }

    @Override
    @NotNull
    public ChatLinks as(String alias) {
        return new ChatLinks(DSL.name(alias), this);
    }

    @Override
    @NotNull
    public ChatLinks as(Name alias) {
        return new ChatLinks(alias, this);
    }

    @Override
    @NotNull
    public ChatLinks as(Table<?> alias) {
        return new ChatLinks(alias.getQualifiedName(), this);
    }

    /**
     * Rename this table
     */
    @Override
    @NotNull
    public ChatLinks rename(String name) {
        return new ChatLinks(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    @NotNull
    public ChatLinks rename(Name name) {
        return new ChatLinks(name, null);
    }

    /**
     * Rename this table
     */
    @Override
    @NotNull
    public ChatLinks rename(Table<?> name) {
        return new ChatLinks(name.getQualifiedName(), null);
    }

    // -------------------------------------------------------------------------
    // Row4 type methods
    // -------------------------------------------------------------------------

    @Override
    @NotNull
    public Row4<Long, Long, Long, String> fieldsRow() {
        return (Row4) super.fieldsRow();
    }

    /**
     * Convenience mapping calling {@link SelectField#convertFrom(Function)}.
     */
    public <U> SelectField<U> mapping(Function4<? super Long, ? super Long, ? super Long, ? super String, ? extends U> from) {
        return convertFrom(Records.mapping(from));
    }

    /**
     * Convenience mapping calling {@link SelectField#convertFrom(Class,
     * Function)}.
     */
    public <U> SelectField<U> mapping(
        Class<U> toType,
        Function4<? super Long, ? super Long, ? super Long, ? super String, ? extends U> from
    ) {
        return convertFrom(toType, Records.mapping(from));
    }
}
