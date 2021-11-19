using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace BezeroetakoDll1
{
    public partial class KontrolaBezero1 : UserControl
    {
        NewTelDataSet kontrolDataSet = new NewTelDataSet();
        public KontrolaBezero1()
        {
            InitializeComponent();
            NewTelDataSetTableAdapters.sale_order_lineTableAdapter salmentaTableAdapter = new NewTelDataSetTableAdapters.sale_order_lineTableAdapter();


            salmentaTableAdapter.Fill(this.kontrolDataSet.sale_order_line);

            //chart1.DataSource = this.kontrolDataSet.sale_order_line.GroupBy(b => b.NANSALTZAILEA).ToDictionary(g => g.Key, g => g.Count());

            chart1.DataSource = salmentaTableAdapter.GetDataBy().Select();

            chart1.Series[0].YValueMembers = "erositakoKantitatea";
            chart1.Series[0].XValueMember = "city"; 
            chart1.DataBind();
        }

    }
}
