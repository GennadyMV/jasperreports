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
package net.sf.jasperreports.charts.base;

import java.awt.Color;
import java.io.Serializable;

import net.sf.jasperreports.charts.JRItemLabel;
import net.sf.jasperreports.engine.JRChart;
import net.sf.jasperreports.engine.JRConstants;
import net.sf.jasperreports.engine.JRExpressionCollector;
import net.sf.jasperreports.engine.JRFont;
import net.sf.jasperreports.engine.JRRuntimeException;
import net.sf.jasperreports.engine.base.JRBaseFont;
import net.sf.jasperreports.engine.base.JRBaseObjectFactory;

/**
 * An immutable representation of the formatting options for showing the
 * item labels in a category plot.
 *
 * @author sanda zaharia (shertage@users.sourceforge.net)
 * @version $Id$
 */
public class JRBaseItemLabel implements JRItemLabel, Serializable
{


	/**
	 *
	 */
	private static final long serialVersionUID = JRConstants.SERIAL_VERSION_UID;

	protected JRChart chart = null;

	/**
	 * The item label text color.
	 */
	protected Color color = null;

	/**
	 * The item label background color.
	 */
	protected Color backgroundColor = null;

	/**
	 * The formatting mask to use when writing the value.  Must a pattern
	 * that is accepted by a code>java.text.DecimalFormat</code> object.
	 */
//	protected String mask = null;

	/**
	 * The item label text font.
	 */
	protected JRFont font = null;


	/**
	 * Constructs a copy of an existing item label specification.
	 *
	 * @param itemLabel the item label object to copy
	 * @param chart the parent chart
	 */
	public JRBaseItemLabel(JRItemLabel itemLabel, JRChart chart)
	{
		this.chart = chart;
		
		if (itemLabel == null)
		{
			font = new JRBaseFont(chart, null);
			color = chart.getForecolor();
			backgroundColor = chart.getBackcolor();
		}
		else
		{
			color = itemLabel.getColor();
			backgroundColor = itemLabel.getBackgroundColor();
//			mask = itemLabel.getMask();
			font = new JRBaseFont(itemLabel.getChart(), itemLabel.getFont());
		}
	}

	/**
	 * Constructs a copy of an existing item label specification and registers
	 * any expression in the new copy with the specified factory.
	 *
	 * @param itemLabel the item label object to copy
	 * @param factory the factory object to register expressions with
	 */
	public JRBaseItemLabel(JRItemLabel itemLabel, JRBaseObjectFactory factory)
	{
		factory.put(itemLabel, this);

		chart = (JRChart)factory.getVisitResult(itemLabel.getChart());

		color = itemLabel.getColor();
		backgroundColor = itemLabel.getBackgroundColor();
//		mask = itemLabel.getMask();
		font = new JRBaseFont(itemLabel.getChart(), itemLabel.getFont());
	}


	/**
	 *
	 */
	public JRChart getChart()
	{
		return chart;
	}

	/**
	 *
	 */
	public Color getColor()
	{
		return color;
	}
	
	/**
	 *
	 */
	public Color getBackgroundColor()
	{
		return backgroundColor;
	}
	/**
	 *
	 */
//	public String getMask()
//	{
//		return mask;
//	}
	/**
	 *
	 */
	public JRFont getFont()
	{
		return font;
	}

	/**
	 * Adds all the expression used by this plot with the specified collector.
	 * All collected expression that are also registered with a factory will
	 * be included with the report is compiled.
	 *
	 * @param collector the expression collector to use
	 */
	public void collectExpressions(JRExpressionCollector collector)
	{
	}

	/**
	 * 
	 */
	public Object clone() 
	{
		try
		{
			return super.clone();
		}
		catch (CloneNotSupportedException e)
		{
			throw new JRRuntimeException(e);
		}
	}
}
