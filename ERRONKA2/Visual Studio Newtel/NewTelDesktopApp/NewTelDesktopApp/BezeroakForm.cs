using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using BezeroakGuztiraDll;

namespace NewTelDesktopApp
{
    public partial class BezeroakForm : Form
    {
        public BezeroakForm()
        {
            //Grafikoak kargatuko ditugu eta datuak kargatuko ditugu
            InitializeComponent();

            //Bezeroen DLL-tako kontrol bat haseratuko dugu ditun bezero kantitatea jakiteko
            KontrrolaBezGuztira bezKant = new KontrrolaBezGuztira();
            labelKant.Text=bezKant.ateraKantitatea();
        }

        private void ButtonAtzeraBezeroak_Click(object sender, EventArgs e)
        {
            //Menura bueltatuko gara
            MenuaForm menuaForm = new MenuaForm();
            menuaForm.Show();
            this.Hide();
        }
    }
}
