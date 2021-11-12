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
    }
}
