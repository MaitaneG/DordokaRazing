using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace SalmentakGuztiraDll
{
    public partial class KontrolaSalmentaGuztira : UserControl
    {
        NewTelDataSet kontrolDataSet = new NewTelDataSet();
        public KontrolaSalmentaGuztira()
        {
            InitializeComponent();
            NewTelDataSetTableAdapters.sale_orderTableAdapter salmentaTableAdapter = new NewTelDataSetTableAdapters.sale_orderTableAdapter();


            salmentaTableAdapter.Fill(this.kontrolDataSet.sale_order);

        }
        public string salmentakEuro()
        {
            sale_orderTableAdapter.Fill(this.kontrolDataSet.sale_order);
            return sale_orderTableAdapter.SalmentakGuztira().ToString();
        }
        public string erosketakEuro()
        {
            purchase_orderTableAdapter.Fill(this.kontrolDataSet.purchase_order);
            return purchase_orderTableAdapter.ErosketakGuztira().ToString();
        }
    }
}
