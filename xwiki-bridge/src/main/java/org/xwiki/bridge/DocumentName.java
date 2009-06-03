/*
 * See the NOTICE file distributed with this work for additional
 * information regarding copyright ownership.
 *
 * This is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation; either version 2.1 of
 * the License, or (at your option) any later version.
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this software; if not, write to the Free
 * Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA
 * 02110-1301 USA, or see the FSF site: http://www.fsf.org.
 */
package org.xwiki.bridge;

import org.xwiki.component.annotation.ComponentRole;

/**
 * Represents a document name (wiki, space and page names).
 * 
 * @version $Id$
 * @since 1.8RC2
 */
@ComponentRole
public class DocumentName
{
    /**
     * @see #getWiki()
     */
    private String wiki;

    /**
     * @see #getSpace()
     */
    private String space;

    /**
     * @see #getPage()
     */
    private String page;

    /**
     * @param wiki the wiki to which the document belongs to (eg "xwiki")
     * @param space the space to which the document belongs to (eg "Main")
     * @param page the page to which the document belongs to (eg "WebHome")
     */
    public DocumentName(String wiki, String space, String page)
    {
        this.wiki = wiki;
        this.space = space;
        this.page = page;
    }

    /**
     * @return the wiki to which the document belongs to
     */
    public String getWiki()
    {
        return this.wiki;
    }

    /**
     * @return the space to which the document belongs to
     */
    public String getSpace()
    {
        return this.space;
    }

    /**
     * @return the page to which the document belongs to
     */
    public String getPage()
    {
        return this.page;
    }

    /**
     * Converts this {@link DocumentName} into a string representation.
     * 
     * @return a string representing this {@link DocumentName} of the form wiki:space.page.
     */
    @Override
    public String toString()
    {
        return "wiki = [" + getWiki() + "], space = [" + getSpace() + "], page = [" + getPage() + "]";
    }

    /**
     * {@inheritDoc}
     * 
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(Object obj)
    {
        boolean equals = false;

        if (obj == this) {
            equals = true;
        } else if (obj instanceof DocumentName) {
            DocumentName documentName = (DocumentName) obj;

            equals =
                (documentName.getWiki() == null ? getWiki() == null : documentName.getWiki().equals(getWiki()))
                    && (documentName.getSpace() == null ? getSpace() == null : documentName.getSpace().equals(
                        getSpace()))
                    && (documentName.getPage() == null ? getPage() == null : documentName.getPage().equals(getPage()));
        }

        return equals;
    }

    /**
     * {@inheritDoc}
     * 
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode()
    {
        return toString().hashCode();
    }
}
