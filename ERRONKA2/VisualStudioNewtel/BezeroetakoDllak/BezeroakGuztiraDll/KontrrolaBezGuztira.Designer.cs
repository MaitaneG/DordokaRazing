
namespace BezeroakGuztiraDll
{
    partial class KontrrolaBezGuztira
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
            this.dataGridView1 = new System.Windows.Forms.DataGridView();
            this.newTelDataSet = new BezeroakGuztiraDll.NewTelDataSet();
            this.newTelDataSetBindingSource = new System.Windows.Forms.BindingSource(this.components);
            this.productproductBindingSource = new System.Windows.Forms.BindingSource(this.components);
            this.product_productTableAdapter = new BezeroakGuztiraDll.NewTelDataSetTableAdapters.product_productTableAdapter();
            this.idDataGridViewTextBoxColumn = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.createdateDataGridViewTextBoxColumn = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.createuidDataGridViewTextBoxColumn = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.writedateDataGridViewTextBoxColumn = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.writeuidDataGridViewTextBoxColumn = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.respartnerBindingSource = new System.Windows.Forms.BindingSource(this.components);
            this.res_partnerTableAdapter = new BezeroakGuztiraDll.NewTelDataSetTableAdapters.res_partnerTableAdapter();
            this.saleorderBindingSource = new System.Windows.Forms.BindingSource(this.components);
            this.sale_orderTableAdapter = new BezeroakGuztiraDll.NewTelDataSetTableAdapters.sale_orderTableAdapter();
            this.saleorderlineBindingSource = new System.Windows.Forms.BindingSource(this.components);
            this.sale_order_lineTableAdapter = new BezeroakGuztiraDll.NewTelDataSetTableAdapters.sale_order_lineTableAdapter();
            ((System.ComponentModel.ISupportInitialize)(this.dataGridView1)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.newTelDataSet)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.newTelDataSetBindingSource)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.productproductBindingSource)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.respartnerBindingSource)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.saleorderBindingSource)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.saleorderlineBindingSource)).BeginInit();
            this.SuspendLayout();
            // 
            // dataGridView1
            // 
            this.dataGridView1.AllowUserToAddRows = false;
            this.dataGridView1.AutoGenerateColumns = false;
            this.dataGridView1.ColumnHeadersHeightSizeMode = System.Windows.Forms.DataGridViewColumnHeadersHeightSizeMode.AutoSize;
            this.dataGridView1.Columns.AddRange(new System.Windows.Forms.DataGridViewColumn[] {
            this.idDataGridViewTextBoxColumn,
            this.createdateDataGridViewTextBoxColumn,
            this.createuidDataGridViewTextBoxColumn,
            this.writedateDataGridViewTextBoxColumn,
            this.writeuidDataGridViewTextBoxColumn});
            this.dataGridView1.DataSource = this.saleorderlineBindingSource;
            this.dataGridView1.Location = new System.Drawing.Point(3, 45);
            this.dataGridView1.Name = "dataGridView1";
            this.dataGridView1.ReadOnly = true;
            this.dataGridView1.Size = new System.Drawing.Size(240, 150);
            this.dataGridView1.TabIndex = 0;
            // 
            // newTelDataSet
            // 
            this.newTelDataSet.DataSetName = "NewTelDataSet";
            this.newTelDataSet.SchemaSerializationMode = System.Data.SchemaSerializationMode.IncludeSchema;
            // 
            // newTelDataSetBindingSource
            // 
            this.newTelDataSetBindingSource.DataSource = this.newTelDataSet;
            this.newTelDataSetBindingSource.Position = 0;
            // 
            // productproductBindingSource
            // 
            this.productproductBindingSource.DataMember = "product_product";
            this.productproductBindingSource.DataSource = this.newTelDataSetBindingSource;
            // 
            // product_productTableAdapter
            // 
            this.product_productTableAdapter.ClearBeforeFill = true;
            // 
            // idDataGridViewTextBoxColumn
            // 
            this.idDataGridViewTextBoxColumn.DataPropertyName = "id";
            this.idDataGridViewTextBoxColumn.HeaderText = "id";
            this.idDataGridViewTextBoxColumn.Name = "idDataGridViewTextBoxColumn";
            this.idDataGridViewTextBoxColumn.ReadOnly = true;
            // 
            // createdateDataGridViewTextBoxColumn
            // 
            this.createdateDataGridViewTextBoxColumn.DataPropertyName = "create_date";
            this.createdateDataGridViewTextBoxColumn.HeaderText = "create_date";
            this.createdateDataGridViewTextBoxColumn.Name = "createdateDataGridViewTextBoxColumn";
            this.createdateDataGridViewTextBoxColumn.ReadOnly = true;
            // 
            // createuidDataGridViewTextBoxColumn
            // 
            this.createuidDataGridViewTextBoxColumn.DataPropertyName = "create_uid";
            this.createuidDataGridViewTextBoxColumn.HeaderText = "create_uid";
            this.createuidDataGridViewTextBoxColumn.Name = "createuidDataGridViewTextBoxColumn";
            this.createuidDataGridViewTextBoxColumn.ReadOnly = true;
            // 
            // writedateDataGridViewTextBoxColumn
            // 
            this.writedateDataGridViewTextBoxColumn.DataPropertyName = "write_date";
            this.writedateDataGridViewTextBoxColumn.HeaderText = "write_date";
            this.writedateDataGridViewTextBoxColumn.Name = "writedateDataGridViewTextBoxColumn";
            this.writedateDataGridViewTextBoxColumn.ReadOnly = true;
            // 
            // writeuidDataGridViewTextBoxColumn
            // 
            this.writeuidDataGridViewTextBoxColumn.DataPropertyName = "write_uid";
            this.writeuidDataGridViewTextBoxColumn.HeaderText = "write_uid";
            this.writeuidDataGridViewTextBoxColumn.Name = "writeuidDataGridViewTextBoxColumn";
            this.writeuidDataGridViewTextBoxColumn.ReadOnly = true;
            // 
            // respartnerBindingSource
            // 
            this.respartnerBindingSource.DataMember = "res_partner";
            this.respartnerBindingSource.DataSource = this.newTelDataSetBindingSource;
            // 
            // res_partnerTableAdapter
            // 
            this.res_partnerTableAdapter.ClearBeforeFill = true;
            // 
            // saleorderBindingSource
            // 
            this.saleorderBindingSource.DataMember = "sale_order";
            this.saleorderBindingSource.DataSource = this.newTelDataSetBindingSource;
            // 
            // sale_orderTableAdapter
            // 
            this.sale_orderTableAdapter.ClearBeforeFill = true;
            // 
            // saleorderlineBindingSource
            // 
            this.saleorderlineBindingSource.DataMember = "sale_order_line";
            this.saleorderlineBindingSource.DataSource = this.newTelDataSetBindingSource;
            // 
            // sale_order_lineTableAdapter
            // 
            this.sale_order_lineTableAdapter.ClearBeforeFill = true;
            // 
            // KontrrolaBezGuztira
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.Controls.Add(this.dataGridView1);
            this.Name = "KontrrolaBezGuztira";
            this.Size = new System.Drawing.Size(276, 232);
            ((System.ComponentModel.ISupportInitialize)(this.dataGridView1)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.newTelDataSet)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.newTelDataSetBindingSource)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.productproductBindingSource)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.respartnerBindingSource)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.saleorderBindingSource)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.saleorderlineBindingSource)).EndInit();
            this.ResumeLayout(false);

        }

        #endregion

        private System.Windows.Forms.DataGridView dataGridView1;
        private System.Windows.Forms.DataGridViewTextBoxColumn idDataGridViewTextBoxColumn;
        private System.Windows.Forms.DataGridViewTextBoxColumn createdateDataGridViewTextBoxColumn;
        private System.Windows.Forms.DataGridViewTextBoxColumn createuidDataGridViewTextBoxColumn;
        private System.Windows.Forms.DataGridViewTextBoxColumn writedateDataGridViewTextBoxColumn;
        private System.Windows.Forms.DataGridViewTextBoxColumn writeuidDataGridViewTextBoxColumn;
        private System.Windows.Forms.BindingSource saleorderlineBindingSource;
        private System.Windows.Forms.BindingSource newTelDataSetBindingSource;
        private NewTelDataSet newTelDataSet;
        private System.Windows.Forms.BindingSource productproductBindingSource;
        private NewTelDataSetTableAdapters.product_productTableAdapter product_productTableAdapter;
        private System.Windows.Forms.BindingSource respartnerBindingSource;
        private NewTelDataSetTableAdapters.res_partnerTableAdapter res_partnerTableAdapter;
        private System.Windows.Forms.BindingSource saleorderBindingSource;
        private NewTelDataSetTableAdapters.sale_orderTableAdapter sale_orderTableAdapter;
        private NewTelDataSetTableAdapters.sale_order_lineTableAdapter sale_order_lineTableAdapter;
    }
}
