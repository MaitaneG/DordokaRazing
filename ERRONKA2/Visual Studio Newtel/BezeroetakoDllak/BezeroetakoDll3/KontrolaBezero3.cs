using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace BezeroetakoDll3
{
    public partial class KontrolaBezero3 : UserControl
    {

        NewTelDataSet kontrolDataSet = new NewTelDataSet();
        public KontrolaBezero3()
        {
            InitializeComponent();
            NewTelDataSetTableAdapters.sale_order_lineTableAdapter salmentaTableAdapter = new NewTelDataSetTableAdapters.sale_order_lineTableAdapter();


            salmentaTableAdapter.Fill(this.kontrolDataSet.sale_order_line);

            chart3.DataSource = salmentaTableAdapter.GetDataBy().Select();
                
                chart3.Series[0].YValueMembers = "erositakoKantitatea";
                chart3.Series[0].XValueMember = "display_name";
                chart3.DataBind();
            }

        
    }
}
