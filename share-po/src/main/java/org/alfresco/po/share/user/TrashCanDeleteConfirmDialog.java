/*
 * #%L
 * share-po
 * %%
 * Copyright (C) 2005 - 2016 Alfresco Software Limited
 * %%
 * This file is part of the Alfresco software. 
 * If the software was purchased under a paid Alfresco license, the terms of 
 * the paid license agreement will prevail.  Otherwise, the software is 
 * provided under the following open source license terms:
 * 
 * Alfresco is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * Alfresco is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 * 
 * You should have received a copy of the GNU Lesser General Public License
 * along with Alfresco. If not, see <http://www.gnu.org/licenses/>.
 * #L%
 */

package org.alfresco.po.share.user;

import static org.alfresco.po.RenderElement.getVisibleRenderElement;

import org.alfresco.po.RenderTime;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;

/**
 * When the users selects Delete of many items in the trashcan they will be
 * presented with confirmation about the list of items Delete. This page is
 * validate the confirmation dialog.
 * 
 * @author Subashni Prasanna
 * @since 1.7.0
 */

public class TrashCanDeleteConfirmDialog extends TrashCanPage
{
    protected static final By DELETE_OK_BUTTON = By.cssSelector("div.ft button");

    @SuppressWarnings("unchecked")
    public TrashCanDeleteConfirmDialog render(RenderTime timer)
    {
        try
        {
            elementRender(timer, getVisibleRenderElement(DELETE_OK_BUTTON));
        }
        catch (NoSuchElementException e)
        {
        }
        catch (TimeoutException e)
        {
        }
        return this;
    }

    @SuppressWarnings("unchecked")
    @Override
    public TrashCanDeleteConfirmDialog render()
    {
        return render(new RenderTime(maxPageLoadingTime));
    }

    /**
     * This method helps to click on OK button
     */
    public TrashCanPage clickDeleteOK()
    {
        driver.findElement(DELETE_OK_BUTTON).click();
        return factoryPage.instantiatePage(driver, TrashCanPage.class);
    }
}
