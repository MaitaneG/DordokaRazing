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
    public partial class HasieraPantailaForm : Form
    {
        MenuaForm menua;

        public HasieraPantailaForm()
        {
            InitializeComponent();
        }

        private void ButtonSubmitLogin_Click(object sender, EventArgs e)
        {
            menua = new MenuaForm();
            menua.Show();
        }

        private void ButtonIrten_Click(object sender, EventArgs e)
        {
            Application.Exit();
        }
    }
}
