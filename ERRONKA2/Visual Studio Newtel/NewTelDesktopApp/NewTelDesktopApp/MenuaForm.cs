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
        private HornitzaileakForm hornitzaileakForm;

        public MenuaForm()
        {
            InitializeComponent();
            hasieratu();
        }

        private void hasieratu()
        {
            //Pantaila desberdinak haseratuko ditugu ondoren hauetan zehar mugitu ahal izateko.
            bezeroakForm = new BezeroakForm();
            finantzakForm = new FinantzakForm();
            hornitzaileakForm = new HornitzaileakForm();
        }

        private void botoiak(object sender, EventArgs e)
        {
            //Klikatzen dugun botoi bakoitzak zer egingo duen definituko dugu.
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
            }
            this.Hide();
        }

        private void linkLabel1_LinkClicked(object sender, System.Windows.Forms.LinkLabelLinkClickedEventArgs e)
        {
            // Hurrengo helbidera joaten da (Gure dendara).
            System.Diagnostics.Process.Start("http:192.168.65.6:8069/");
        }

        private void buttonAtzeraMenua_Click(object sender, EventArgs e)
        {
            //Mezu bat agertuko zaigu galdetzen ea ziur gauden irten nahi dugula
            DialogResult dialogResult = MessageBox.Show("Ziur zaude aplikaziotik irten nahi duzula?", "Kontuz!", MessageBoxButtons.YesNo);
            if (dialogResult == DialogResult.Yes)
            {
                Application.Exit();
            }
            else if (dialogResult == DialogResult.No)
            {
            }
        }
    }
}
