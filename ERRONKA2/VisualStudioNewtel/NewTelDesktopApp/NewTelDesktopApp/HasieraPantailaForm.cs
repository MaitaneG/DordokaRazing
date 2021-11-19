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
            //Korreoa eta pasahitza sakatu eta gero konprobatuko dugu ea sartutako datuak zuzenak diren
            if (textBoxKorreoa.Text.Equals("gmail@gmail.com") && textBoxPasahitza.Text.Equals("password"))
            {
                //Datuak zuzenak direnez Menuaren pabtailara joango gara
                label2.Enabled = false;
                menua = new MenuaForm();
                menua.Show();
                this.Hide();
            }
            //Daturen bat okerra bada mezu bat agertuko zaigu honetaz ohartarazten
            else
            {
                label2.Enabled = true;
            }
        }

        private void ButtonIrten_Click(object sender, EventArgs e)
        {
            //Aplikaziotik irtengo gara
            Application.Exit();
        }

        private void textBoxKorreoa_Click(object sender, EventArgs e)
        {
            //Korreoaren kutxan klik egitean kutxa hustuko da korreoa sartzeko
            if (textBoxKorreoa.Text.Equals("Korreo elektronikoa"))
            {
                textBoxKorreoa.Text = "";
            }
        }

        private void textBoxPasahitza_Click(object sender, EventArgs e)
        {
            //Pasahitzaren kutxan klik egitean kutxa hustuko da eta karaktereak * bezela agertuko dira pasahitza ez ikusteko.
            if (textBoxPasahitza.Text.Equals("Pasahitza"))
            {
                textBoxPasahitza.Text = "";
                textBoxPasahitza.PasswordChar = '*';
            }
        }
    }
}
