using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace NewTelDesktopApp
{
    public partial class MenuaForm : Form
    {
        private FinantzakForm finantzakForm;
        private BezeroakForm bezeroakForm;
        private HasieraPantailaForm hasieraPantailaForm;
        private HornitzaileakForm hornitzaileakForm;


        public MenuaForm()
        {
            InitializeComponent();
            hasieratu();
        }
        private void hasieratu()
        {
            bezeroakForm = new BezeroakForm();
            finantzakForm = new FinantzakForm();
            hasieraPantailaForm = new HasieraPantailaForm();
            hornitzaileakForm = new HornitzaileakForm();
        }

        private void botoiak(object sender, EventArgs e)
        {
            String botoia = (sender as Button).Text;
            switch (botoia)
            {
                case "BEZEROAK":
                    bezeroakForm.Show();
                    break;
                case "FINANTZAK":
                    finantzakForm.Show();
                    break;
                case "HORNITZAILEAK":
                    hornitzaileakForm.Show();
                    break;
                case "ATZERA":
                    hasieraPantailaForm.Show();
                    break;
            }
            this.Hide();
        }

        private void linkLabel1_LinkClicked(object sender, System.Windows.Forms.LinkLabelLinkClickedEventArgs e)
        {
            // Specify that the link was visited.
            this.linkLabel1.LinkVisited = true;

            // Navigate to a URL.
            System.Diagnostics.Process.Start("http:25.35.135.250//localhost:8069/");
        }
    }
}
