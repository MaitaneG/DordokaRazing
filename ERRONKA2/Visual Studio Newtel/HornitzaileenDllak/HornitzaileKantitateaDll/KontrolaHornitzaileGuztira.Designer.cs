
namespace HornitzaileKantitateaDll
{
    partial class KontrolaHornitzaileGuztira
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
            this.newTelDataSet = new HornitzaileKantitateaDll.NewTelDataSet();
            this.purchaseorderBindingSource = new System.Windows.Forms.BindingSource(this.components);
            this.purchase_orderTableAdapter = new HornitzaileKantitateaDll.NewTelDataSetTableAdapters.purchase_orderTableAdapter();
            this.idDataGridViewTextBoxColumn = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.accesstokenDataGridViewTextBoxColumn = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.amounttaxDataGridViewTextBoxColumn = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.amounttotalDataGridViewTextBoxColumn = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.amountuntaxedDataGridViewTextBoxColumn = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.companyidDataGridViewTextBoxColumn = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.createdateDataGridViewTextBoxColumn = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.createuidDataGridViewTextBoxColumn = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.currencyidDataGridViewTextBoxColumn = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.currencyrateDataGridViewTextBoxColumn = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.dateapproveDataGridViewTextBoxColumn = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.datecalendarstartDataGridViewTextBoxColumn = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.dateorderDataGridViewTextBoxColumn = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.dateplannedDataGridViewTextBoxColumn = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.effectivedateDataGridViewTextBoxColumn = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.fiscalpositionidDataGridViewTextBoxColumn = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.groupidDataGridViewTextBoxColumn = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.incotermidDataGridViewTextBoxColumn = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.invoicecountDataGridViewTextBoxColumn = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.invoicestatusDataGridViewTextBoxColumn = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.messagemainattachmentidDataGridViewTextBoxColumn = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.nameDataGridViewTextBoxColumn = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.notesDataGridViewTextBoxColumn = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.originDataGridViewTextBoxColumn = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.partnerrefDataGridViewTextBoxColumn = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.paymenttermidDataGridViewTextBoxColumn = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.pickingcountDataGridViewTextBoxColumn = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.pickingtypeidDataGridViewTextBoxColumn = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.priorityDataGridViewTextBoxColumn = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.stateDataGridViewTextBoxColumn = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.useridDataGridViewTextBoxColumn = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.writedateDataGridViewTextBoxColumn = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.writeuidDataGridViewTextBoxColumn = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.destaddressidDataGridViewTextBoxColumn = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.partneridDataGridViewTextBoxColumn = new System.Windows.Forms.DataGridViewTextBoxColumn();
            ((System.ComponentModel.ISupportInitialize)(this.dataGridView1)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.newTelDataSet)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.purchaseorderBindingSource)).BeginInit();
            this.SuspendLayout();
            // 
            // dataGridView1
            // 
            this.dataGridView1.AutoGenerateColumns = false;
            this.dataGridView1.ColumnHeadersHeightSizeMode = System.Windows.Forms.DataGridViewColumnHeadersHeightSizeMode.AutoSize;
            this.dataGridView1.Columns.AddRange(new System.Windows.Forms.DataGridViewColumn[] {
            this.idDataGridViewTextBoxColumn,
            this.accesstokenDataGridViewTextBoxColumn,
            this.amounttaxDataGridViewTextBoxColumn,
            this.amounttotalDataGridViewTextBoxColumn,
            this.amountuntaxedDataGridViewTextBoxColumn,
            this.companyidDataGridViewTextBoxColumn,
            this.createdateDataGridViewTextBoxColumn,
            this.createuidDataGridViewTextBoxColumn,
            this.currencyidDataGridViewTextBoxColumn,
            this.currencyrateDataGridViewTextBoxColumn,
            this.dateapproveDataGridViewTextBoxColumn,
            this.datecalendarstartDataGridViewTextBoxColumn,
            this.dateorderDataGridViewTextBoxColumn,
            this.dateplannedDataGridViewTextBoxColumn,
            this.effectivedateDataGridViewTextBoxColumn,
            this.fiscalpositionidDataGridViewTextBoxColumn,
            this.groupidDataGridViewTextBoxColumn,
            this.incotermidDataGridViewTextBoxColumn,
            this.invoicecountDataGridViewTextBoxColumn,
            this.invoicestatusDataGridViewTextBoxColumn,
            this.messagemainattachmentidDataGridViewTextBoxColumn,
            this.nameDataGridViewTextBoxColumn,
            this.notesDataGridViewTextBoxColumn,
            this.originDataGridViewTextBoxColumn,
            this.partnerrefDataGridViewTextBoxColumn,
            this.paymenttermidDataGridViewTextBoxColumn,
            this.pickingcountDataGridViewTextBoxColumn,
            this.pickingtypeidDataGridViewTextBoxColumn,
            this.priorityDataGridViewTextBoxColumn,
            this.stateDataGridViewTextBoxColumn,
            this.useridDataGridViewTextBoxColumn,
            this.writedateDataGridViewTextBoxColumn,
            this.writeuidDataGridViewTextBoxColumn,
            this.destaddressidDataGridViewTextBoxColumn,
            this.partneridDataGridViewTextBoxColumn});
            this.dataGridView1.DataSource = this.purchaseorderBindingSource;
            this.dataGridView1.Location = new System.Drawing.Point(30, 62);
            this.dataGridView1.Name = "dataGridView1";
            this.dataGridView1.Size = new System.Drawing.Size(240, 150);
            this.dataGridView1.TabIndex = 0;
            // 
            // newTelDataSet
            // 
            this.newTelDataSet.DataSetName = "NewTelDataSet";
            this.newTelDataSet.SchemaSerializationMode = System.Data.SchemaSerializationMode.IncludeSchema;
            // 
            // purchaseorderBindingSource
            // 
            this.purchaseorderBindingSource.DataMember = "purchase_order";
            this.purchaseorderBindingSource.DataSource = this.newTelDataSet;
            // 
            // purchase_orderTableAdapter
            // 
            this.purchase_orderTableAdapter.ClearBeforeFill = true;
            // 
            // idDataGridViewTextBoxColumn
            // 
            this.idDataGridViewTextBoxColumn.DataPropertyName = "id";
            this.idDataGridViewTextBoxColumn.HeaderText = "id";
            this.idDataGridViewTextBoxColumn.Name = "idDataGridViewTextBoxColumn";
            // 
            // accesstokenDataGridViewTextBoxColumn
            // 
            this.accesstokenDataGridViewTextBoxColumn.DataPropertyName = "access_token";
            this.accesstokenDataGridViewTextBoxColumn.HeaderText = "access_token";
            this.accesstokenDataGridViewTextBoxColumn.Name = "accesstokenDataGridViewTextBoxColumn";
            // 
            // amounttaxDataGridViewTextBoxColumn
            // 
            this.amounttaxDataGridViewTextBoxColumn.DataPropertyName = "amount_tax";
            this.amounttaxDataGridViewTextBoxColumn.HeaderText = "amount_tax";
            this.amounttaxDataGridViewTextBoxColumn.Name = "amounttaxDataGridViewTextBoxColumn";
            // 
            // amounttotalDataGridViewTextBoxColumn
            // 
            this.amounttotalDataGridViewTextBoxColumn.DataPropertyName = "amount_total";
            this.amounttotalDataGridViewTextBoxColumn.HeaderText = "amount_total";
            this.amounttotalDataGridViewTextBoxColumn.Name = "amounttotalDataGridViewTextBoxColumn";
            // 
            // amountuntaxedDataGridViewTextBoxColumn
            // 
            this.amountuntaxedDataGridViewTextBoxColumn.DataPropertyName = "amount_untaxed";
            this.amountuntaxedDataGridViewTextBoxColumn.HeaderText = "amount_untaxed";
            this.amountuntaxedDataGridViewTextBoxColumn.Name = "amountuntaxedDataGridViewTextBoxColumn";
            // 
            // companyidDataGridViewTextBoxColumn
            // 
            this.companyidDataGridViewTextBoxColumn.DataPropertyName = "company_id";
            this.companyidDataGridViewTextBoxColumn.HeaderText = "company_id";
            this.companyidDataGridViewTextBoxColumn.Name = "companyidDataGridViewTextBoxColumn";
            // 
            // createdateDataGridViewTextBoxColumn
            // 
            this.createdateDataGridViewTextBoxColumn.DataPropertyName = "create_date";
            this.createdateDataGridViewTextBoxColumn.HeaderText = "create_date";
            this.createdateDataGridViewTextBoxColumn.Name = "createdateDataGridViewTextBoxColumn";
            // 
            // createuidDataGridViewTextBoxColumn
            // 
            this.createuidDataGridViewTextBoxColumn.DataPropertyName = "create_uid";
            this.createuidDataGridViewTextBoxColumn.HeaderText = "create_uid";
            this.createuidDataGridViewTextBoxColumn.Name = "createuidDataGridViewTextBoxColumn";
            // 
            // currencyidDataGridViewTextBoxColumn
            // 
            this.currencyidDataGridViewTextBoxColumn.DataPropertyName = "currency_id";
            this.currencyidDataGridViewTextBoxColumn.HeaderText = "currency_id";
            this.currencyidDataGridViewTextBoxColumn.Name = "currencyidDataGridViewTextBoxColumn";
            // 
            // currencyrateDataGridViewTextBoxColumn
            // 
            this.currencyrateDataGridViewTextBoxColumn.DataPropertyName = "currency_rate";
            this.currencyrateDataGridViewTextBoxColumn.HeaderText = "currency_rate";
            this.currencyrateDataGridViewTextBoxColumn.Name = "currencyrateDataGridViewTextBoxColumn";
            // 
            // dateapproveDataGridViewTextBoxColumn
            // 
            this.dateapproveDataGridViewTextBoxColumn.DataPropertyName = "date_approve";
            this.dateapproveDataGridViewTextBoxColumn.HeaderText = "date_approve";
            this.dateapproveDataGridViewTextBoxColumn.Name = "dateapproveDataGridViewTextBoxColumn";
            // 
            // datecalendarstartDataGridViewTextBoxColumn
            // 
            this.datecalendarstartDataGridViewTextBoxColumn.DataPropertyName = "date_calendar_start";
            this.datecalendarstartDataGridViewTextBoxColumn.HeaderText = "date_calendar_start";
            this.datecalendarstartDataGridViewTextBoxColumn.Name = "datecalendarstartDataGridViewTextBoxColumn";
            // 
            // dateorderDataGridViewTextBoxColumn
            // 
            this.dateorderDataGridViewTextBoxColumn.DataPropertyName = "date_order";
            this.dateorderDataGridViewTextBoxColumn.HeaderText = "date_order";
            this.dateorderDataGridViewTextBoxColumn.Name = "dateorderDataGridViewTextBoxColumn";
            // 
            // dateplannedDataGridViewTextBoxColumn
            // 
            this.dateplannedDataGridViewTextBoxColumn.DataPropertyName = "date_planned";
            this.dateplannedDataGridViewTextBoxColumn.HeaderText = "date_planned";
            this.dateplannedDataGridViewTextBoxColumn.Name = "dateplannedDataGridViewTextBoxColumn";
            // 
            // effectivedateDataGridViewTextBoxColumn
            // 
            this.effectivedateDataGridViewTextBoxColumn.DataPropertyName = "effective_date";
            this.effectivedateDataGridViewTextBoxColumn.HeaderText = "effective_date";
            this.effectivedateDataGridViewTextBoxColumn.Name = "effectivedateDataGridViewTextBoxColumn";
            // 
            // fiscalpositionidDataGridViewTextBoxColumn
            // 
            this.fiscalpositionidDataGridViewTextBoxColumn.DataPropertyName = "fiscal_position_id";
            this.fiscalpositionidDataGridViewTextBoxColumn.HeaderText = "fiscal_position_id";
            this.fiscalpositionidDataGridViewTextBoxColumn.Name = "fiscalpositionidDataGridViewTextBoxColumn";
            // 
            // groupidDataGridViewTextBoxColumn
            // 
            this.groupidDataGridViewTextBoxColumn.DataPropertyName = "group_id";
            this.groupidDataGridViewTextBoxColumn.HeaderText = "group_id";
            this.groupidDataGridViewTextBoxColumn.Name = "groupidDataGridViewTextBoxColumn";
            // 
            // incotermidDataGridViewTextBoxColumn
            // 
            this.incotermidDataGridViewTextBoxColumn.DataPropertyName = "incoterm_id";
            this.incotermidDataGridViewTextBoxColumn.HeaderText = "incoterm_id";
            this.incotermidDataGridViewTextBoxColumn.Name = "incotermidDataGridViewTextBoxColumn";
            // 
            // invoicecountDataGridViewTextBoxColumn
            // 
            this.invoicecountDataGridViewTextBoxColumn.DataPropertyName = "invoice_count";
            this.invoicecountDataGridViewTextBoxColumn.HeaderText = "invoice_count";
            this.invoicecountDataGridViewTextBoxColumn.Name = "invoicecountDataGridViewTextBoxColumn";
            // 
            // invoicestatusDataGridViewTextBoxColumn
            // 
            this.invoicestatusDataGridViewTextBoxColumn.DataPropertyName = "invoice_status";
            this.invoicestatusDataGridViewTextBoxColumn.HeaderText = "invoice_status";
            this.invoicestatusDataGridViewTextBoxColumn.Name = "invoicestatusDataGridViewTextBoxColumn";
            // 
            // messagemainattachmentidDataGridViewTextBoxColumn
            // 
            this.messagemainattachmentidDataGridViewTextBoxColumn.DataPropertyName = "message_main_attachment_id";
            this.messagemainattachmentidDataGridViewTextBoxColumn.HeaderText = "message_main_attachment_id";
            this.messagemainattachmentidDataGridViewTextBoxColumn.Name = "messagemainattachmentidDataGridViewTextBoxColumn";
            // 
            // nameDataGridViewTextBoxColumn
            // 
            this.nameDataGridViewTextBoxColumn.DataPropertyName = "name";
            this.nameDataGridViewTextBoxColumn.HeaderText = "name";
            this.nameDataGridViewTextBoxColumn.Name = "nameDataGridViewTextBoxColumn";
            // 
            // notesDataGridViewTextBoxColumn
            // 
            this.notesDataGridViewTextBoxColumn.DataPropertyName = "notes";
            this.notesDataGridViewTextBoxColumn.HeaderText = "notes";
            this.notesDataGridViewTextBoxColumn.Name = "notesDataGridViewTextBoxColumn";
            // 
            // originDataGridViewTextBoxColumn
            // 
            this.originDataGridViewTextBoxColumn.DataPropertyName = "origin";
            this.originDataGridViewTextBoxColumn.HeaderText = "origin";
            this.originDataGridViewTextBoxColumn.Name = "originDataGridViewTextBoxColumn";
            // 
            // partnerrefDataGridViewTextBoxColumn
            // 
            this.partnerrefDataGridViewTextBoxColumn.DataPropertyName = "partner_ref";
            this.partnerrefDataGridViewTextBoxColumn.HeaderText = "partner_ref";
            this.partnerrefDataGridViewTextBoxColumn.Name = "partnerrefDataGridViewTextBoxColumn";
            // 
            // paymenttermidDataGridViewTextBoxColumn
            // 
            this.paymenttermidDataGridViewTextBoxColumn.DataPropertyName = "payment_term_id";
            this.paymenttermidDataGridViewTextBoxColumn.HeaderText = "payment_term_id";
            this.paymenttermidDataGridViewTextBoxColumn.Name = "paymenttermidDataGridViewTextBoxColumn";
            // 
            // pickingcountDataGridViewTextBoxColumn
            // 
            this.pickingcountDataGridViewTextBoxColumn.DataPropertyName = "picking_count";
            this.pickingcountDataGridViewTextBoxColumn.HeaderText = "picking_count";
            this.pickingcountDataGridViewTextBoxColumn.Name = "pickingcountDataGridViewTextBoxColumn";
            // 
            // pickingtypeidDataGridViewTextBoxColumn
            // 
            this.pickingtypeidDataGridViewTextBoxColumn.DataPropertyName = "picking_type_id";
            this.pickingtypeidDataGridViewTextBoxColumn.HeaderText = "picking_type_id";
            this.pickingtypeidDataGridViewTextBoxColumn.Name = "pickingtypeidDataGridViewTextBoxColumn";
            // 
            // priorityDataGridViewTextBoxColumn
            // 
            this.priorityDataGridViewTextBoxColumn.DataPropertyName = "priority";
            this.priorityDataGridViewTextBoxColumn.HeaderText = "priority";
            this.priorityDataGridViewTextBoxColumn.Name = "priorityDataGridViewTextBoxColumn";
            // 
            // stateDataGridViewTextBoxColumn
            // 
            this.stateDataGridViewTextBoxColumn.DataPropertyName = "state";
            this.stateDataGridViewTextBoxColumn.HeaderText = "state";
            this.stateDataGridViewTextBoxColumn.Name = "stateDataGridViewTextBoxColumn";
            // 
            // useridDataGridViewTextBoxColumn
            // 
            this.useridDataGridViewTextBoxColumn.DataPropertyName = "user_id";
            this.useridDataGridViewTextBoxColumn.HeaderText = "user_id";
            this.useridDataGridViewTextBoxColumn.Name = "useridDataGridViewTextBoxColumn";
            // 
            // writedateDataGridViewTextBoxColumn
            // 
            this.writedateDataGridViewTextBoxColumn.DataPropertyName = "write_date";
            this.writedateDataGridViewTextBoxColumn.HeaderText = "write_date";
            this.writedateDataGridViewTextBoxColumn.Name = "writedateDataGridViewTextBoxColumn";
            // 
            // writeuidDataGridViewTextBoxColumn
            // 
            this.writeuidDataGridViewTextBoxColumn.DataPropertyName = "write_uid";
            this.writeuidDataGridViewTextBoxColumn.HeaderText = "write_uid";
            this.writeuidDataGridViewTextBoxColumn.Name = "writeuidDataGridViewTextBoxColumn";
            // 
            // destaddressidDataGridViewTextBoxColumn
            // 
            this.destaddressidDataGridViewTextBoxColumn.DataPropertyName = "dest_address_id";
            this.destaddressidDataGridViewTextBoxColumn.HeaderText = "dest_address_id";
            this.destaddressidDataGridViewTextBoxColumn.Name = "destaddressidDataGridViewTextBoxColumn";
            // 
            // partneridDataGridViewTextBoxColumn
            // 
            this.partneridDataGridViewTextBoxColumn.DataPropertyName = "partner_id";
            this.partneridDataGridViewTextBoxColumn.HeaderText = "partner_id";
            this.partneridDataGridViewTextBoxColumn.Name = "partneridDataGridViewTextBoxColumn";
            // 
            // KontrolaHornitzaileGuztira
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.Controls.Add(this.dataGridView1);
            this.Name = "KontrolaHornitzaileGuztira";
            this.Size = new System.Drawing.Size(294, 256);
            ((System.ComponentModel.ISupportInitialize)(this.dataGridView1)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.newTelDataSet)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.purchaseorderBindingSource)).EndInit();
            this.ResumeLayout(false);

        }

        #endregion

        private System.Windows.Forms.DataGridView dataGridView1;
        private System.Windows.Forms.DataGridViewTextBoxColumn idDataGridViewTextBoxColumn;
        private System.Windows.Forms.DataGridViewTextBoxColumn accesstokenDataGridViewTextBoxColumn;
        private System.Windows.Forms.DataGridViewTextBoxColumn amounttaxDataGridViewTextBoxColumn;
        private System.Windows.Forms.DataGridViewTextBoxColumn amounttotalDataGridViewTextBoxColumn;
        private System.Windows.Forms.DataGridViewTextBoxColumn amountuntaxedDataGridViewTextBoxColumn;
        private System.Windows.Forms.DataGridViewTextBoxColumn companyidDataGridViewTextBoxColumn;
        private System.Windows.Forms.DataGridViewTextBoxColumn createdateDataGridViewTextBoxColumn;
        private System.Windows.Forms.DataGridViewTextBoxColumn createuidDataGridViewTextBoxColumn;
        private System.Windows.Forms.DataGridViewTextBoxColumn currencyidDataGridViewTextBoxColumn;
        private System.Windows.Forms.DataGridViewTextBoxColumn currencyrateDataGridViewTextBoxColumn;
        private System.Windows.Forms.DataGridViewTextBoxColumn dateapproveDataGridViewTextBoxColumn;
        private System.Windows.Forms.DataGridViewTextBoxColumn datecalendarstartDataGridViewTextBoxColumn;
        private System.Windows.Forms.DataGridViewTextBoxColumn dateorderDataGridViewTextBoxColumn;
        private System.Windows.Forms.DataGridViewTextBoxColumn dateplannedDataGridViewTextBoxColumn;
        private System.Windows.Forms.DataGridViewTextBoxColumn effectivedateDataGridViewTextBoxColumn;
        private System.Windows.Forms.DataGridViewTextBoxColumn fiscalpositionidDataGridViewTextBoxColumn;
        private System.Windows.Forms.DataGridViewTextBoxColumn groupidDataGridViewTextBoxColumn;
        private System.Windows.Forms.DataGridViewTextBoxColumn incotermidDataGridViewTextBoxColumn;
        private System.Windows.Forms.DataGridViewTextBoxColumn invoicecountDataGridViewTextBoxColumn;
        private System.Windows.Forms.DataGridViewTextBoxColumn invoicestatusDataGridViewTextBoxColumn;
        private System.Windows.Forms.DataGridViewTextBoxColumn messagemainattachmentidDataGridViewTextBoxColumn;
        private System.Windows.Forms.DataGridViewTextBoxColumn nameDataGridViewTextBoxColumn;
        private System.Windows.Forms.DataGridViewTextBoxColumn notesDataGridViewTextBoxColumn;
        private System.Windows.Forms.DataGridViewTextBoxColumn originDataGridViewTextBoxColumn;
        private System.Windows.Forms.DataGridViewTextBoxColumn partnerrefDataGridViewTextBoxColumn;
        private System.Windows.Forms.DataGridViewTextBoxColumn paymenttermidDataGridViewTextBoxColumn;
        private System.Windows.Forms.DataGridViewTextBoxColumn pickingcountDataGridViewTextBoxColumn;
        private System.Windows.Forms.DataGridViewTextBoxColumn pickingtypeidDataGridViewTextBoxColumn;
        private System.Windows.Forms.DataGridViewTextBoxColumn priorityDataGridViewTextBoxColumn;
        private System.Windows.Forms.DataGridViewTextBoxColumn stateDataGridViewTextBoxColumn;
        private System.Windows.Forms.DataGridViewTextBoxColumn useridDataGridViewTextBoxColumn;
        private System.Windows.Forms.DataGridViewTextBoxColumn writedateDataGridViewTextBoxColumn;
        private System.Windows.Forms.DataGridViewTextBoxColumn writeuidDataGridViewTextBoxColumn;
        private System.Windows.Forms.DataGridViewTextBoxColumn destaddressidDataGridViewTextBoxColumn;
        private System.Windows.Forms.DataGridViewTextBoxColumn partneridDataGridViewTextBoxColumn;
        private System.Windows.Forms.BindingSource purchaseorderBindingSource;
        private NewTelDataSet newTelDataSet;
        private NewTelDataSetTableAdapters.purchase_orderTableAdapter purchase_orderTableAdapter;
    }
}
