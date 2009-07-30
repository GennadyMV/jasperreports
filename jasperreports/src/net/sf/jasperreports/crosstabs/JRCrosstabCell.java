/*
 * ============================================================================
 * GNU Lesser General Public License
 * ============================================================================
 *
 * JasperReports - Free Java report-generating library.
 * Copyright (C) 2001-2009 JasperSoft Corporation http://www.jaspersoft.com
 * 
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 * 
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 * 
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307, USA.
 * 
 * JasperSoft Corporation
 * 539 Bryant Street, Suite 100
 * San Francisco, CA 94107
 * http://www.jaspersoft.com
 */
package net.sf.jasperreports.crosstabs;

import net.sf.jasperreports.engine.JRCloneable;

/**
 * Crosstab data cell interface.
 * 
 * @author Lucian Chirita (lucianc@users.sourceforge.net)
 * @version $Id$
 * @see net.sf.jasperreports.crosstabs.JRCrosstab#getCells()
 */
public interface JRCrosstabCell extends JRCloneable
{
	/**
	 * Returns the width of the cell.
	 * <p>
	 * The width of the cell can be unspecified.
	 * The width used for the cell is computed base on the rules described
	 * {@link net.sf.jasperreports.crosstabs.JRCrosstab#getCells() here}.
	 * 
	 * @return the width of the cell
	 */
	public Integer getWidth();
	
	
	/**
	 * Returns the height of the cell.
	 * <p>
	 * The height of the cell can be unspecified.
	 * The height used for the cell is computed base on the rules described
	 * {@link net.sf.jasperreports.crosstabs.JRCrosstab#getCells() here}.
	 * 
	 * @return the width of the cell
	 */
	public Integer getHeight();
	
	
	/**
	 * Returns the name of the row group if the crosstab cell corresponds to a total row
	 * and <code>null</code> otherwise.
	 * 
	 * @return the name of the total row group this cell corresponds to
	 */
	public String getRowTotalGroup();
	
	
	/**
	 * Returns the name of the column group if the crosstab cell corresponds to a total column
	 * and <code>null</code> otherwise.
	 * 
	 * @return the name of the total column group this cell corresponds to
	 */
	public String getColumnTotalGroup();
	
	
	/**
	 * Returns the cell contents.
	 * <p>
	 * Should never return null, but empty cell contents instead.
	 * 
	 * @return the cell contents
	 */
	public JRCellContents getContents();
}
