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
            InitializeComponent();
            KontrolaHornitzaileGuztira horniGuzt = new KontrolaHornitzaileGuztira();
            labelKant.Text = horniGuzt.ateraKantitatea();
        }

        private void ButtonAtzeraBezeroak_Click(object sender, EventArgs e)
        {
            MenuaForm menuaForm = new MenuaForm();
            menuaForm.Show();
            this.Hide();
        }
    }
}
