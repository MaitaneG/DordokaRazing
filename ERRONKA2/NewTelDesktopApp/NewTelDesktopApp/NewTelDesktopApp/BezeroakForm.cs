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
            InitializeComponent();
            KontrrolaBezGuztira bezKant = new KontrrolaBezGuztira();
            labelKant.Text=bezKant.ateraKantitatea();
        }

        private void ButtonAtzeraBezeroak_Click(object sender, EventArgs e)
        {
            MenuaForm menuaForm = new MenuaForm();
            menuaForm.Show();
            this.Hide();
        }

        private void kontrolaBezero21_Load(object sender, EventArgs e)
        {

        }
    }
}
