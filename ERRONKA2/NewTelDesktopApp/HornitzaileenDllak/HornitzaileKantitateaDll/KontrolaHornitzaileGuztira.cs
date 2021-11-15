using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace HornitzaileKantitateaDll
{
    public partial class KontrolaHornitzaileGuztira : UserControl
    {
        NewTelDataSet kontrolDataSet = new NewTelDataSet();
        public KontrolaHornitzaileGuztira()
        {
            InitializeComponent();
            NewTelDataSetTableAdapters.purchase_orderTableAdapter salmentaTableAdapter = new NewTelDataSetTableAdapters.purchase_orderTableAdapter();


            salmentaTableAdapter.Fill(this.kontrolDataSet.purchase_order);
        }
        public string ateraKantitatea()
        {
            purchase_orderTableAdapter.Fill(this.kontrolDataSet.purchase_order);
            return purchase_orderTableAdapter.HornitzaileGuztira().ToString();
        }
    }
}
