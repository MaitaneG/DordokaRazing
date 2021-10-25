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
    public partial class HasieraPantaila : Form
    {
        Menua menua;

        public HasieraPantaila()
        {
            InitializeComponent();
        }

        private void ButtonSubmitLogin_Click(object sender, EventArgs e)
        {
            menua = new Menua();
            menua.Show();
        }
    }
}
