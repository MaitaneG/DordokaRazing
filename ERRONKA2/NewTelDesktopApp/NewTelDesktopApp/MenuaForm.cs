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
        public MenuaForm()
        {
            InitializeComponent();
        }

        private void Button3_Click(object sender, EventArgs e)
        {
            BezeroakFormcs bezeroakForms = new BezeroakFormcs();

            bezeroakForms.Show();
        }
    }
}
