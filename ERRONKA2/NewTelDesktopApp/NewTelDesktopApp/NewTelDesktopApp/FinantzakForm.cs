using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using SalmentakGuztiraDll;

namespace NewTelDesktopApp
{
    public partial class FinantzakForm : Form
    {
        public FinantzakForm()
        {
            InitializeComponent();
            KontrolaSalmentaGuztira euroak = new KontrolaSalmentaGuztira();
            labelSalduEuro.Text = euroak.salmentakEuro()+"€";
            labelErosiEuro.Text = euroak.erosketakEuro() + "€";
            decimal irabaziak = decimal.Parse(euroak.salmentakEuro()) - decimal.Parse(euroak.erosketakEuro());
            labelTotala.Text =irabaziak.ToString() + "€";
        }

        private void ButtonAtzeraBezeroak_Click(object sender, EventArgs e)
        {
            MenuaForm menua = new MenuaForm();
            menua.Show();
            this.Hide();
        }
    }
}
