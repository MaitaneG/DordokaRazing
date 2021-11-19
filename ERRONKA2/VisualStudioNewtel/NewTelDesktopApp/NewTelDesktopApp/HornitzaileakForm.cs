using HornitzaileKantitateaDll;
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
    public partial class HornitzaileakForm : Form
    {
        public HornitzaileakForm()
        {
            //Grafikoak kargatuko ditugu eta datuak kargatuko ditugu
            InitializeComponent();

            //Hornaitzaileen DLL-tako kontrol bat haseratuko dugu ditun hornitzaile kantitatea jakiteko
            KontrolaHornitzaileGuztira horniGuzt = new KontrolaHornitzaileGuztira();
            labelKant.Text = horniGuzt.ateraKantitatea();
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
