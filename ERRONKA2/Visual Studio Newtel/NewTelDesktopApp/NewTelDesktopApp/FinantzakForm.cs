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
            //Grafikoak kargatuko ditugu eta datuak kargatuko ditugu
            InitializeComponent();

            //Finantzen DLL-tako kontrol bat haseratuko dugu ditun erosketen eta salmenten zenbatekoak jakiteko

            KontrolaSalmentaGuztira euroak = new KontrolaSalmentaGuztira();
            labelSalduEuro.Text = euroak.salmentakEuro()+"€";
            labelErosiEuro.Text = euroak.erosketakEuro() + "€";

            //Salmenten eta erosketen arteko diferentzia kalkulatuko dugu
            decimal irabaziak = decimal.Parse(euroak.salmentakEuro()) - decimal.Parse(euroak.erosketakEuro());
            labelTotala.Text =irabaziak.ToString() + "€";
        }

        private void ButtonAtzeraBezeroak_Click(object sender, EventArgs e)
        {
            //Menura bueltatuko gara
            MenuaForm menua = new MenuaForm();
            menua.Show();
            this.Hide();
        }
    }
}
