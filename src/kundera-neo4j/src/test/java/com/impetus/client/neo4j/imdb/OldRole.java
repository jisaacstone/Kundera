/**
 * Copyright 2012 Impetus Infotech.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.impetus.client.neo4j.imdb;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.impetus.kundera.index.Index;
import com.impetus.kundera.index.IndexCollection;

/**
 * Role Relationship entity class
 * 
 * @author amresh.singh
 */
@Entity
@Table
@IndexCollection(columns = { @Index(name = "roleType", type = "KEYS") })
public class OldRole
{
    @Id
    @Column(name = "ROLE_NAME")
    private String roleName;

    @Column(name = "ROLE_TYPE")
    private String roleType;

    @OneToOne
    private ActorWithMultipleRelation actor;

    @OneToOne
    private ArchivedMovie movie;

    public OldRole()
    {
    }

    public OldRole(String roleName, String roleType)
    {
        this.roleName = roleName;
        this.roleType = roleType;
    }

    /**
     * @return the roleName
     */
    public String getRoleName()
    {
        return roleName;
    }

    /**
     * @param roleName
     *            the roleName to set
     */
    public void setRoleName(String roleName)
    {
        this.roleName = roleName;
    }

    /**
     * @return the roleType
     */
    public String getRoleType()
    {
        return roleType;
    }

    /**
     * @param roleType
     *            the roleType to set
     */
    public void setRoleType(String roleType)
    {
        this.roleType = roleType;
    }

    /**
     * @return the actor
     */
    public ActorWithMultipleRelation getActor()
    {
        return actor;
    }

    /**
     * @param actor
     *            the actor to set
     */
    public void setActor(ActorWithMultipleRelation actor)
    {
        this.actor = actor;
    }

    /**
     * @return the movie
     */
    public ArchivedMovie getMovie()
    {
        return movie;
    }

    /**
     * @param movie
     *            the movie to set
     */
    public void setMovie(ArchivedMovie movie)
    {
        this.movie = movie;
    }

    public boolean equals(Object o)
    {
        if (!(o instanceof OldRole))
        {
            return false;
        }

        OldRole that = (OldRole) o;

        return (this.roleName == that.roleName || this.roleName.equals(that.roleName))
                && (this.roleType == that.roleType || this.roleType.equals(that.roleType));

    }

    public int hashCode()
    {
        int h1 = (roleName == null) ? 0 : roleName.hashCode();
        int h2 = (roleType == null) ? 0 : roleType.hashCode();
        return h1 + 31 * h2;
    }

}
