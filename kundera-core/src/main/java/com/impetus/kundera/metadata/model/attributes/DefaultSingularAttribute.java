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
package com.impetus.kundera.metadata.model.attributes;

import java.lang.reflect.Field;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.metamodel.ManagedType;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.Type;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


/**
 *  TODO::::: comments required.
 * @author vivek.mishra
 *
 * @param <X>
 * @param <T>
 */

public class DefaultSingularAttribute<X, T> extends AbstractAttribute<X, T> implements SingularAttribute<X, T>
{
    /** the log used by this class. */
    private static Log log = LogFactory.getLog(DefaultSingularAttribute.class);
    
    /**
     * @param attribName
     * @param persistenceAttribType
     * @param member
     * @param attribType
     * @param managedType
     */
    public DefaultSingularAttribute(String attribName,
            javax.persistence.metamodel.Attribute.PersistentAttributeType persistenceAttribType, Field member,
            Type<T> attribType, ManagedType<X> managedType)
    {
        super(attribType,attribName,persistenceAttribType,managedType,member);
//        this.javaType = javaType;
    }
    

    /* (non-Javadoc)
     * @see javax.persistence.metamodel.Attribute#isCollection()
     */
    @Override
    public boolean isCollection()
    {
        return false;
    }

    /* (non-Javadoc)
     * @see javax.persistence.metamodel.Bindable#getBindableType()
     */
    @Override
    public javax.persistence.metamodel.Bindable.BindableType getBindableType()
    {
        return BindableType.SINGULAR_ATTRIBUTE;
    }

 

    /* (non-Javadoc)
     * @see javax.persistence.metamodel.SingularAttribute#isId()
     */
    @Override
    public boolean isId()
    {
        return member.isAnnotationPresent(Id.class) || member.isAnnotationPresent(IdClass.class) ;
    }

    /* (non-Javadoc)
     * @see javax.persistence.metamodel.SingularAttribute#isVersion()
     */
    @Override
    public boolean isVersion()
    {
        log.info("Currently versioning is not supported in kundera, returning false as default");
        return false;
    }

    /* (non-Javadoc)
     * @see javax.persistence.metamodel.SingularAttribute#isOptional()
     */
    @Override
   public boolean isOptional()
    {
        boolean isNullable=true;
        if(!isId())
        {
            Column anno = member.getAnnotation(Column.class);
            if(anno != null)
            {
                isNullable = anno.nullable();
            }
        } else
        {
            isNullable = false;
        }
        return isNullable ;
    }

    /* (non-Javadoc)
     * @see javax.persistence.metamodel.SingularAttribute#getType()
     */
    @Override
    public Type<T> getType()
    {
        return attribType ;
    }


    /* (non-Javadoc)
     * @see com.impetus.kundera.metadata.model.attributes.AbstractAttribute#getJavaType()
     */
    @Override 
    public Class<T> getJavaType()
    {
        return attribType.getJavaType();
    }


}
