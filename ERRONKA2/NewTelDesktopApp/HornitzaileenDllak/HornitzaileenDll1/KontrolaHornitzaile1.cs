using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace HornitzaileenDll1
{
    public partial class KontrolaHornitzaile1 : UserControl
    {
        NewTelDataSet kontrolDataSet = new NewTelDataSet();
        public KontrolaHornitzaile1()
        {
            InitializeComponent();
            NewTelDataSetTableAdapters.NireTaulaTableAdapter salmentaTableAdapter = new NewTelDataSetTableAdapters.NireTaulaTableAdapter();


            salmentaTableAdapter.Fill(this.kontrolDataSet.NireTaula);

            chart3.DataSource = salmentaTableAdapter.GetDataBy().Select();

            chart3.Series[0].YValueMembers = "prodKant";
            chart3.Series[0].XValueMember = "display_name";
            chart3.DataBind();
        }
    }
}
