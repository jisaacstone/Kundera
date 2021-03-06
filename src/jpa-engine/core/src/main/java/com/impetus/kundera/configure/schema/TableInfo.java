/*******************************************************************************
 * * Copyright 2012 Impetus Infotech.
 *  *
 *  * Licensed under the Apache License, Version 2.0 (the "License");
 *  * you may not use this file except in compliance with the License.
 *  * You may obtain a copy of the License at
 *  *
 *  *      http://www.apache.org/licenses/LICENSE-2.0
 *  *
 *  * Unless required by applicable law or agreed to in writing, software
 *  * distributed under the License is distributed on an "AS IS" BASIS,
 *  * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  * See the License for the specific language governing permissions and
 *  * limitations under the License.
 ******************************************************************************/
package com.impetus.kundera.configure.schema;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.builder.HashCodeBuilder;

/**
 * TableInfo class holds table creation related information.
 * 
 * @author Kuldeep.Kumar
 * 
 */
public class TableInfo
{
    /** The table name. */
    private String tableName;

    /** The column metadatas. */
    private List<ColumnInfo> columnMetadatas;

    /** The table id class. */
    private Class<?> idClazz;

    /** The table id name. */
    private String idColumnName;

    /** The type. */
    private String type;

    /** The embedded column metadatas. */
    private List<EmbeddedColumnInfo> embeddedColumnMetadatas;

    /** The collection column metadatas. */
    private List<CollectionColumnInfo> collectionColumnMetadatas;

    /**
     * 
     */
    private List<IndexInfo> columnToBeIndexed = new ArrayList<IndexInfo>();

    /**
     * Instantiates a new table info.
     * 
     * @param tableName
     *            the table name
     * @param isIndexable
     *            the is indexable
     * @param tableSchemaType
     *            the table schema type
     * @param idClassType
     *            the id class type
     */
    public TableInfo(String tableName, String tableSchemaType, Class<?> idClassType, String idColumnName)
    {
        this.tableName = tableName;
        this.type = tableSchemaType;
        this.idClazz = idClassType;
        this.idColumnName = idColumnName;
    }

    /**
     * Equals method compare two object of TableInfo on the basis of their name
     * .
     * 
     * @param obj
     *            the obj
     * @return boolean value.
     */
    @Override
    public boolean equals(Object obj)
    {

        return obj != null && obj instanceof TableInfo && ((TableInfo) obj).tableName != null ? this.tableName != null
                && this.tableName.equals(((TableInfo) obj).tableName) : false;

    }

    @Override
    /**
     * returns the hash code for object. 
     * 
     */
    public int hashCode()
    {
        return HashCodeBuilder.reflectionHashCode(this);
    }

    @Override
    /**
     * returns the string representation of object .
     * 
     */
    public String toString()
    {
        StringBuilder strBuilder = new StringBuilder("tableIdType:==> ");
        strBuilder.append(idClazz);
        strBuilder.append(" | tableName: ==>");
        strBuilder.append(tableName);
        strBuilder.append(" | type: ==>");
        strBuilder.append(type);
        return strBuilder.toString();
    }

    /**
     * Gets the table name.
     * 
     * @return the tableName
     */
    public String getTableName()
    {
        return tableName;
    }

    /**
     * Sets the table name.
     * 
     * @param tableName
     *            the tableName to set
     */
    public void setTableName(String tableName)
    {
        this.tableName = tableName;
    }

    /**
     * Gets the table id type.
     * 
     * @return the tableIdType
     */
    public Class<?> getTableIdType()
    {
        return idClazz;
    }

    /**
     * Sets the table id type.
     * 
     * @param tableIdType
     *            the tableIdType to set
     */
    public void setTableIdType(Class<?> tableIdType)
    {
        this.idClazz = tableIdType;
    }

    /**
     * Gets the column metadatas.
     * 
     * @return the columnMetadatas
     */
    public List<ColumnInfo> getColumnMetadatas()
    {

        if (this.columnMetadatas == null)
        {
            this.columnMetadatas = new ArrayList<ColumnInfo>();
        }

        return columnMetadatas;
    }

    /**
     * Adds the column info.
     * 
     * @param columnInfo
     *            the column info
     */
    public void addColumnInfo(ColumnInfo columnInfo)
    {
        if (this.columnMetadatas == null)
        {
            this.columnMetadatas = new ArrayList<ColumnInfo>();
        }
        if (!columnMetadatas.contains(columnInfo) && !this.getIdColumnName().equals(columnInfo.getColumnName()))
        {
            columnMetadatas.add(columnInfo);
        }
    }

    /**
     * Adds the embedded column info.
     * 
     * @param embdColumnInfo
     *            the embd column info
     */
    public void addEmbeddedColumnInfo(EmbeddedColumnInfo embdColumnInfo)
    {
        if (this.embeddedColumnMetadatas == null)
        {
            this.embeddedColumnMetadatas = new ArrayList<EmbeddedColumnInfo>();
        }
        if (!embeddedColumnMetadatas.contains(embdColumnInfo))
        {
            embeddedColumnMetadatas.add(embdColumnInfo);
        }
    }

    /**
     * Gets the embedded column metadatas.
     * 
     * @return the embeddedColumnMetadatas
     */
    public List<EmbeddedColumnInfo> getEmbeddedColumnMetadatas()
    {
        if (this.embeddedColumnMetadatas == null)
        {
            this.embeddedColumnMetadatas = new ArrayList<EmbeddedColumnInfo>();
        }
        return embeddedColumnMetadatas;
    }

    /**
     * @return the collectionColumnMetadatas
     */
    public List<CollectionColumnInfo> getCollectionColumnMetadatas()
    {
        if (this.collectionColumnMetadatas == null)
        {
            this.collectionColumnMetadatas = new ArrayList<CollectionColumnInfo>();
        }
        return collectionColumnMetadatas;
    }

    /**
     * @param collectionColumnMetadatas
     *            the collectionColumnMetadatas to set
     */
    public void addCollectionColumnMetadata(CollectionColumnInfo collectionColumnMetadata)
    {
        if (this.collectionColumnMetadatas == null)
        {
            this.collectionColumnMetadatas = new ArrayList<CollectionColumnInfo>();
        }

        if (!collectionColumnMetadatas.contains(collectionColumnMetadata))
        {
            collectionColumnMetadatas.add(collectionColumnMetadata);
        }
    }

    /**
     * Gets the type.
     * 
     * @return the type
     */
    public String getType()
    {
        return type;
    }

    /**
     * Returns name of id attribute.
     * 
     * @return id attribute name.
     */
    public String getIdColumnName()
    {
        return idColumnName;
    }

    /**
     * Returns list of index information object.
     * 
     * @return
     */
    public List<IndexInfo> getColumnsToBeIndexed()
    {
        return this.columnToBeIndexed;
    }

    public IndexInfo getColumnToBeIndexed(String columnName)
    {
        IndexInfo idxInfo = new IndexInfo(columnName);
        if (columnToBeIndexed.contains(idxInfo))
        {
            int index = columnToBeIndexed.indexOf(idxInfo);
            return getColumnsToBeIndexed().get(index);
        }
        return idxInfo;
    }

    public void addToIndexedColumnList(IndexInfo indexInfo)
    {
        ColumnInfo columnInfo = new ColumnInfo();
        columnInfo.setColumnName(indexInfo.getColumnName());
        if (getEmbeddedColumnMetadatas().isEmpty()
                || !getEmbeddedColumnMetadatas().get(0).getColumns().contains(columnInfo))
        {
            if (!columnToBeIndexed.contains(indexInfo))
            {
                columnToBeIndexed.add(indexInfo);
            }
        }
    }
}