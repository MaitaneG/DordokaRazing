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
            label2.Enabled = false;
            
        }

        private void ButtonSubmitLogin_Click(object sender, EventArgs e)
        {

            if (textBoxKorreoa.Text.Equals("gmail@gmail.com") && textBoxPasahitza.Text.Equals("password"))
            {
                label2.Enabled = false;
                menua = new MenuaForm();
                menua.Show();
                this.Hide();
        }
            else
            {
                label2.Enabled = true;
            }

}

        private void ButtonIrten_Click(object sender, EventArgs e)
        {
            Application.Exit();
        }

        private void textBoxKorreoa_Click(object sender, EventArgs e)
        {
            if(textBoxKorreoa.Text.Equals("Korreo elektronikoa"))
            {
                textBoxKorreoa.Text = "";
            }
        }

        private void textBoxPasahitza_Click(object sender, EventArgs e)
        {
            if (textBoxPasahitza.Text.Equals("Pasahitza"))
            {
                textBoxPasahitza.Text = "";
                textBoxPasahitza.PasswordChar = '*';
            }
        }
    }
}
