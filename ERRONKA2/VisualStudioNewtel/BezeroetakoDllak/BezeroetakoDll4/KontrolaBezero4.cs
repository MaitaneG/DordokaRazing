using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace BezeroetakoDll4
{
    public partial class KontrolaBezero4 : UserControl
    {
        NewTelDataSet kontrolDataSet = new NewTelDataSet();
        public KontrolaBezero4()
        {
            InitializeComponent();
            NewTelDataSetTableAdapters.res_partnerTableAdapter salmentaTableAdapter = new NewTelDataSetTableAdapters.res_partnerTableAdapter();


            salmentaTableAdapter.Fill(this.kontrolDataSet.res_partner);
            chart4.DataSource = kontrolDataSet.res_partner
                .GroupBy(p => p.create_date.ToShortDateString())
                .Select(i => new { create_date = i.Key, egunBakoitzeko = i.Count() });       

            chart4.Series[0].YValueMembers = "egunbakoitzeko";
            chart4.Series[0].XValueMember = "create_date";
            chart4.DataBind();
        }
    }
}
