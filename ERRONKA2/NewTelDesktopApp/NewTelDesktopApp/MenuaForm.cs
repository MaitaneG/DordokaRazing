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
                case "ATZERA":
                    hasieraPantailaForm.Show();
                    break;
            }
            this.Hide();
        }
    }
}
