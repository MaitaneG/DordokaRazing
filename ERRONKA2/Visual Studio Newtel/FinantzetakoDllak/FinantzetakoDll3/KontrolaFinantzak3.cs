using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace FinantzetakoDll3
{
    public partial class KontrolaFinantzak3 : UserControl
    {
        SalmentaDBDataSet kontrolDataSet = new SalmentaDBDataSet();
        public KontrolaFinantzak3()
        {
            InitializeComponent();
            SalmentaDBDataSetTableAdapters.SALMENTATableAdapter bezeroaTableAdapter = new SalmentaDBDataSetTableAdapters.SALMENTATableAdapter();


            bezeroaTableAdapter.Fill(this.kontrolDataSet.SALMENTA);

            chart1.DataSource = this.kontrolDataSet.SALMENTA
                .GroupBy(b => b.NANBEZEROA)
                .ToDictionary(g => g.Key, g => g.Count());

            chart1.Series[0].YValueMembers = "Value";
            chart1.Series[0].XValueMember = "Key";
            chart1.DataBind();
        }
    }
}
