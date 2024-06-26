/*
 * This file is generated by jOOQ.
 */

package edu.java.scrapper.core.dao.jooq.generated.tables.records;

import edu.java.scrapper.core.dao.jooq.generated.tables.ChatLinks;
import jakarta.validation.constraints.Size;
import java.beans.ConstructorProperties;
import javax.annotation.processing.Generated;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record4;
import org.jooq.Row4;
import org.jooq.impl.UpdatableRecordImpl;

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
public class ChatLinksRecord extends UpdatableRecordImpl<ChatLinksRecord> implements Record4<Long, Long, Long, String> {

    private static final long serialVersionUID = 1L;

    /**
     * Setter for <code>CHAT_LINKS.ID</code>.
     */
    public void setId(@NotNull Long value) {
        set(0, value);
    }

    /**
     * Getter for <code>CHAT_LINKS.ID</code>.
     */
    @NotNull
    public Long getId() {
        return (Long) get(0);
    }

    /**
     * Setter for <code>CHAT_LINKS.CHAT_ID</code>.
     */
    public void setChatId(@Nullable Long value) {
        set(1, value);
    }

    /**
     * Getter for <code>CHAT_LINKS.CHAT_ID</code>.
     */
    @Nullable
    public Long getChatId() {
        return (Long) get(1);
    }

    /**
     * Setter for <code>CHAT_LINKS.LINK_ID</code>.
     */
    public void setLinkId(@Nullable Long value) {
        set(2, value);
    }

    /**
     * Getter for <code>CHAT_LINKS.LINK_ID</code>.
     */
    @Nullable
    public Long getLinkId() {
        return (Long) get(2);
    }

    /**
     * Setter for <code>CHAT_LINKS.SHORT_NAME</code>.
     */
    public void setShortName(@NotNull String value) {
        set(3, value);
    }

    /**
     * Getter for <code>CHAT_LINKS.SHORT_NAME</code>.
     */
    @Size(max = 40)
    @NotNull
    public String getShortName() {
        return (String) get(3);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    @Override
    @NotNull
    public Record1<Long> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record4 type implementation
    // -------------------------------------------------------------------------

    @Override
    @NotNull
    public Row4<Long, Long, Long, String> fieldsRow() {
        return (Row4) super.fieldsRow();
    }

    @Override
    @NotNull
    public Row4<Long, Long, Long, String> valuesRow() {
        return (Row4) super.valuesRow();
    }

    @Override
    @NotNull
    public Field<Long> field1() {
        return ChatLinks.CHAT_LINKS.ID;
    }

    @Override
    @NotNull
    public Field<Long> field2() {
        return ChatLinks.CHAT_LINKS.CHAT_ID;
    }

    @Override
    @NotNull
    public Field<Long> field3() {
        return ChatLinks.CHAT_LINKS.LINK_ID;
    }

    @Override
    @NotNull
    public Field<String> field4() {
        return ChatLinks.CHAT_LINKS.SHORT_NAME;
    }

    @Override
    @NotNull
    public Long component1() {
        return getId();
    }

    @Override
    @Nullable
    public Long component2() {
        return getChatId();
    }

    @Override
    @Nullable
    public Long component3() {
        return getLinkId();
    }

    @Override
    @NotNull
    public String component4() {
        return getShortName();
    }

    @Override
    @NotNull
    public Long value1() {
        return getId();
    }

    @Override
    @Nullable
    public Long value2() {
        return getChatId();
    }

    @Override
    @Nullable
    public Long value3() {
        return getLinkId();
    }

    @Override
    @NotNull
    public String value4() {
        return getShortName();
    }

    @Override
    @NotNull
    public ChatLinksRecord value1(@NotNull Long value) {
        setId(value);
        return this;
    }

    @Override
    @NotNull
    public ChatLinksRecord value2(@Nullable Long value) {
        setChatId(value);
        return this;
    }

    @Override
    @NotNull
    public ChatLinksRecord value3(@Nullable Long value) {
        setLinkId(value);
        return this;
    }

    @Override
    @NotNull
    public ChatLinksRecord value4(@NotNull String value) {
        setShortName(value);
        return this;
    }

    @Override
    @NotNull
    public ChatLinksRecord values(
        @NotNull Long value1,
        @Nullable Long value2,
        @Nullable Long value3,
        @NotNull String value4
    ) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached ChatLinksRecord
     */
    public ChatLinksRecord() {
        super(ChatLinks.CHAT_LINKS);
    }

    /**
     * Create a detached, initialised ChatLinksRecord
     */
    @ConstructorProperties({"id", "chatId", "linkId", "shortName"})
    public ChatLinksRecord(@NotNull Long id, @Nullable Long chatId, @Nullable Long linkId, @NotNull String shortName) {
        super(ChatLinks.CHAT_LINKS);

        setId(id);
        setChatId(chatId);
        setLinkId(linkId);
        setShortName(shortName);
    }

    /**
     * Create a detached, initialised ChatLinksRecord
     */
    public ChatLinksRecord(edu.java.scrapper.core.dao.jooq.generated.tables.pojos.ChatLinks value) {
        super(ChatLinks.CHAT_LINKS);

        if (value != null) {
            setId(value.getId());
            setChatId(value.getChatId());
            setLinkId(value.getLinkId());
            setShortName(value.getShortName());
        }
    }
}
