
namespace BezeroetakoDll1
{
    partial class KontrolaBezero1
    {
        /// <summary> 
        /// Variable del diseñador necesaria.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary> 
        /// Limpiar los recursos que se estén usando.
        /// </summary>
        /// <param name="disposing">true si los recursos administrados se deben desechar; false en caso contrario.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Código generado por el Diseñador de componentes

        /// <summary> 
        /// Método necesario para admitir el Diseñador. No se puede modificar
        /// el contenido de este método con el editor de código.
        /// </summary>
        private void InitializeComponent()
        {
            this.components = new System.ComponentModel.Container();
            System.Windows.Forms.DataVisualization.Charting.ChartArea chartArea1 = new System.Windows.Forms.DataVisualization.Charting.ChartArea();
            System.Windows.Forms.DataVisualization.Charting.Legend legend1 = new System.Windows.Forms.DataVisualization.Charting.Legend();
            System.Windows.Forms.DataVisualization.Charting.Series series1 = new System.Windows.Forms.DataVisualization.Charting.Series();
            this.chart1 = new System.Windows.Forms.DataVisualization.Charting.Chart();
            this.saleorderlineBindingSource = new System.Windows.Forms.BindingSource(this.components);
            this.newTelDataSetBindingSource = new System.Windows.Forms.BindingSource(this.components);
            this.newTelDataSet = new BezeroetakoDll1.NewTelDataSet();
            this.bEZEROABindingSource = new System.Windows.Forms.BindingSource(this.components);
            this.salmentaDBDataSet = new BezeroetakoDll1.SalmentaDBDataSet();
            this.bEZEROATableAdapter = new BezeroetakoDll1.SalmentaDBDataSetTableAdapters.BEZEROATableAdapter();
            this.label1 = new System.Windows.Forms.Label();
            this.groupBox1 = new System.Windows.Forms.GroupBox();
            this.sale_order_lineTableAdapter = new BezeroetakoDll1.NewTelDataSetTableAdapters.sale_order_lineTableAdapter();
            ((System.ComponentModel.ISupportInitialize)(this.chart1)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.saleorderlineBindingSource)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.newTelDataSetBindingSource)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.newTelDataSet)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.bEZEROABindingSource)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.salmentaDBDataSet)).BeginInit();
            this.groupBox1.SuspendLayout();
            this.SuspendLayout();
            // 
            // chart1
            // 
            this.chart1.BackColor = System.Drawing.Color.Transparent;
            chartArea1.Area3DStyle.Enable3D = true;
            chartArea1.BackColor = System.Drawing.Color.Transparent;
            chartArea1.Name = "ChartArea1";
            this.chart1.ChartAreas.Add(chartArea1);
            this.chart1.DataSource = this.saleorderlineBindingSource;
            legend1.BackColor = System.Drawing.Color.Transparent;
            legend1.ForeColor = System.Drawing.Color.White;
            legend1.Name = "Legend1";
            this.chart1.Legends.Add(legend1);
            this.chart1.Location = new System.Drawing.Point(55, 47);
            this.chart1.Margin = new System.Windows.Forms.Padding(2);
            this.chart1.Name = "chart1";
            this.chart1.Palette = System.Windows.Forms.DataVisualization.Charting.ChartColorPalette.SeaGreen;
            series1.ChartArea = "ChartArea1";
            series1.ChartType = System.Windows.Forms.DataVisualization.Charting.SeriesChartType.Pie;
            series1.Color = System.Drawing.Color.Transparent;
            series1.IsValueShownAsLabel = true;
            series1.IsXValueIndexed = true;
            series1.LabelForeColor = System.Drawing.Color.Transparent;
            series1.Legend = "Legend1";
            series1.Name = "Series1";
            this.chart1.Series.Add(series1);
            this.chart1.Size = new System.Drawing.Size(258, 171);
            this.chart1.TabIndex = 1;
            this.chart1.Text = "chart1";
            // 
            // saleorderlineBindingSource
            // 
            this.saleorderlineBindingSource.DataMember = "sale_order_line";
            this.saleorderlineBindingSource.DataSource = this.newTelDataSetBindingSource;
            // 
            // newTelDataSetBindingSource
            // 
            this.newTelDataSetBindingSource.DataSource = this.newTelDataSet;
            this.newTelDataSetBindingSource.Position = 0;
            // 
            // newTelDataSet
            // 
            this.newTelDataSet.DataSetName = "NewTelDataSet";
            this.newTelDataSet.SchemaSerializationMode = System.Data.SchemaSerializationMode.IncludeSchema;
            // 
            // bEZEROABindingSource
            // 
            this.bEZEROABindingSource.DataMember = "BEZEROA";
            this.bEZEROABindingSource.DataSource = this.salmentaDBDataSet;
            // 
            // salmentaDBDataSet
            // 
            this.salmentaDBDataSet.DataSetName = "SalmentaDBDataSet";
            this.salmentaDBDataSet.SchemaSerializationMode = System.Data.SchemaSerializationMode.IncludeSchema;
            // 
            // bEZEROATableAdapter
            // 
            this.bEZEROATableAdapter.ClearBeforeFill = true;
            // 
            // label1
            // 
            this.label1.AutoSize = true;
            this.label1.Font = new System.Drawing.Font("Microsoft Sans Serif", 12F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.label1.ForeColor = System.Drawing.Color.White;
            this.label1.Location = new System.Drawing.Point(6, 16);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(361, 20);
            this.label1.TabIndex = 2;
            this.label1.Text = "NORA BIDALTZEN DUGU PRODUKTU GEHIEN";
            // 
            // groupBox1
            // 
            this.groupBox1.Controls.Add(this.chart1);
            this.groupBox1.Controls.Add(this.label1);
            this.groupBox1.Location = new System.Drawing.Point(3, 3);
            this.groupBox1.Name = "groupBox1";
            this.groupBox1.Size = new System.Drawing.Size(380, 215);
            this.groupBox1.TabIndex = 3;
            this.groupBox1.TabStop = false;
            // 
            // sale_order_lineTableAdapter
            // 
            this.sale_order_lineTableAdapter.ClearBeforeFill = true;
            // 
            // KontrolaBezero1
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.Controls.Add(this.groupBox1);
            this.Name = "KontrolaBezero1";
            this.Size = new System.Drawing.Size(388, 218);
            ((System.ComponentModel.ISupportInitialize)(this.chart1)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.saleorderlineBindingSource)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.newTelDataSetBindingSource)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.newTelDataSet)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.bEZEROABindingSource)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.salmentaDBDataSet)).EndInit();
            this.groupBox1.ResumeLayout(false);
            this.groupBox1.PerformLayout();
            this.ResumeLayout(false);

        }

        #endregion

        private System.Windows.Forms.DataVisualization.Charting.Chart chart1;
        private System.Windows.Forms.BindingSource bEZEROABindingSource;
        private SalmentaDBDataSet salmentaDBDataSet;
        private SalmentaDBDataSetTableAdapters.BEZEROATableAdapter bEZEROATableAdapter;
        private System.Windows.Forms.Label label1;
        private System.Windows.Forms.GroupBox groupBox1;
        private System.Windows.Forms.BindingSource saleorderlineBindingSource;
        private System.Windows.Forms.BindingSource newTelDataSetBindingSource;
        private NewTelDataSet newTelDataSet;
        private NewTelDataSetTableAdapters.sale_order_lineTableAdapter sale_order_lineTableAdapter;
    }
}
