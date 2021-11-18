using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace BezeroetakoDll2
{
    public partial class KontrolaBezero2 : UserControl
    {
        NewTelDataSet kontrolDataSet = new NewTelDataSet();
        public KontrolaBezero2()
        {
            InitializeComponent();
            NewTelDataSetTableAdapters.sale_orderTableAdapter salmentaTableAdapter = new NewTelDataSetTableAdapters.sale_orderTableAdapter();


            salmentaTableAdapter.Fill(this.kontrolDataSet.sale_order);
            chart2.DataSource = salmentaTableAdapter.GetDataBy().Select();        

            chart2.Series[0].YValueMembers = "prezioTotala";
            chart2.Series[0].XValueMember = "izena";
            chart2.DataBind();
        }
    }
}
