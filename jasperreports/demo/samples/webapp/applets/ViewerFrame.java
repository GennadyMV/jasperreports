/*
 * ============================================================================
 *                   GNU Lesser General Public License
 * ============================================================================
 *
 * JasperReports - Free Java report-generating library.
 * Copyright (C) 2001-2005 Teodor Danciu teodord@users.sourceforge.net
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
 * Teodor Danciu
 * 173, Calea Calarasilor, Bl. 42, Sc. 1, Ap. 18
 * Postal code 030615, Sector 3
 * Bucharest, ROMANIA
 * Email: teodord@users.sourceforge.net
 */
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.view.*;

import java.awt.BorderLayout;
import java.applet.AppletContext;
import java.net.*;
import javax.swing.JOptionPane;


/**
 * @author Teodor Danciu (teodord@users.sourceforge.net)
 * @version $Id$
 */
public class ViewerFrame extends javax.swing.JFrame implements JRHyperlinkListener
{


	/**
	 *
	 */
	private AppletContext appletContext = null;


	/**
	 *
	 */
	public ViewerFrame(AppletContext appletContext, JasperPrint jasperPrint) throws JRException
	{
		initComponents();

		this.appletContext = appletContext;
		
		JRViewerPlus viewer = new JRViewerPlus(jasperPrint);
		viewer.addHyperlinkListener(this);
		this.pnlMain.add(viewer, BorderLayout.CENTER);
	}

	
	/**
	 *
	 */
	public void gotoHyperlink(JRPrintHyperlink hyperlink)
	{
		switch(hyperlink.getHyperlinkType())
		{
			case JRHyperlink.HYPERLINK_TYPE_REFERENCE :
			{
				try
				{
					this.appletContext.showDocument(new URL(hyperlink.getHyperlinkReference()), "_blank");
				}
				catch (MalformedURLException e)
				{
					JOptionPane.showMessageDialog(this, e.getMessage());
				}
				break;
			}
			case JRHyperlink.HYPERLINK_TYPE_LOCAL_ANCHOR :
			case JRHyperlink.HYPERLINK_TYPE_LOCAL_PAGE :
			{
				break;
			}
			case JRHyperlink.HYPERLINK_TYPE_REMOTE_ANCHOR :
			case JRHyperlink.HYPERLINK_TYPE_REMOTE_PAGE :
			{
				JOptionPane.showMessageDialog(this, "Implement your own JRHyperlinkListener to manage this type of event.");
				break;
			}
			case JRHyperlink.HYPERLINK_TYPE_NONE :
			default :
			{
				break;
			}
		}
	}


    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    private void initComponents() {//GEN-BEGIN:initComponents
        pnlMain = new javax.swing.JPanel();

        setTitle("JasperViewer");
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        pnlMain.setLayout(new java.awt.BorderLayout());

        getContentPane().add(pnlMain, java.awt.BorderLayout.CENTER);

        pack();
        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setSize(new java.awt.Dimension(400, 300));
        setLocation((screenSize.width-400)/2,(screenSize.height-300)/2);
    }//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel pnlMain;
    // End of variables declaration//GEN-END:variables

}
