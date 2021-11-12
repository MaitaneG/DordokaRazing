namespace NewTelDesktopApp
{
    partial class HasieraPantailaForm
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

        #region Código generado por el Diseñador de Windows Forms

        /// <summary>
        /// Método necesario para admitir el Diseñador. No se puede modificar
        /// el contenido de este método con el editor de código.
        /// </summary>
        private void InitializeComponent()
        {
            System.ComponentModel.ComponentResourceManager resources = new System.ComponentModel.ComponentResourceManager(typeof(HasieraPantailaForm));
            this.label1 = new System.Windows.Forms.Label();
            this.textBoxPasahitza = new System.Windows.Forms.TextBox();
            this.buttonSubmitLogin = new System.Windows.Forms.Button();
            this.textBoxKorreoa = new System.Windows.Forms.TextBox();
            this.buttonIrten = new System.Windows.Forms.Button();
            this.SuspendLayout();
            // 
            // label1
            // 
            this.label1.AutoSize = true;
            this.label1.Font = new System.Drawing.Font("Verdana", 24F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.label1.ForeColor = System.Drawing.Color.Red;
            this.label1.Location = new System.Drawing.Point(351, 148);
            this.label1.Margin = new System.Windows.Forms.Padding(4, 0, 4, 0);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(295, 48);
            this.label1.TabIndex = 0;
            this.label1.Text = "HASI SAIOA";
            // 
            // textBoxPasahitza
            // 
            this.textBoxPasahitza.Font = new System.Drawing.Font("Microsoft Sans Serif", 12F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.textBoxPasahitza.Location = new System.Drawing.Point(344, 288);
            this.textBoxPasahitza.Margin = new System.Windows.Forms.Padding(4, 4, 4, 4);
            this.textBoxPasahitza.Name = "textBoxPasahitza";
            this.textBoxPasahitza.PasswordChar = '*';
            this.textBoxPasahitza.Size = new System.Drawing.Size(336, 30);
            this.textBoxPasahitza.TabIndex = 2;
            this.textBoxPasahitza.Text = "Pasahitza";
            // 
            // buttonSubmitLogin
            // 
            this.buttonSubmitLogin.BackColor = System.Drawing.Color.Black;
            this.buttonSubmitLogin.FlatAppearance.BorderColor = System.Drawing.Color.Red;
            this.buttonSubmitLogin.FlatAppearance.BorderSize = 2;
            this.buttonSubmitLogin.FlatStyle = System.Windows.Forms.FlatStyle.Flat;
            this.buttonSubmitLogin.Font = new System.Drawing.Font("Nirmala UI", 13.8F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.buttonSubmitLogin.ForeColor = System.Drawing.Color.White;
            this.buttonSubmitLogin.Location = new System.Drawing.Point(344, 391);
            this.buttonSubmitLogin.Margin = new System.Windows.Forms.Padding(4, 4, 4, 4);
            this.buttonSubmitLogin.Name = "buttonSubmitLogin";
            this.buttonSubmitLogin.Size = new System.Drawing.Size(156, 48);
            this.buttonSubmitLogin.TabIndex = 3;
            this.buttonSubmitLogin.Text = "SARTU";
            this.buttonSubmitLogin.UseVisualStyleBackColor = false;
            this.buttonSubmitLogin.Click += new System.EventHandler(this.ButtonSubmitLogin_Click);
            // 
            // textBoxKorreoa
            // 
            this.textBoxKorreoa.Font = new System.Drawing.Font("Microsoft Sans Serif", 12F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.textBoxKorreoa.Location = new System.Drawing.Point(344, 231);
            this.textBoxKorreoa.Margin = new System.Windows.Forms.Padding(4, 4, 4, 4);
            this.textBoxKorreoa.Name = "textBoxKorreoa";
            this.textBoxKorreoa.Size = new System.Drawing.Size(336, 30);
            this.textBoxKorreoa.TabIndex = 4;
            this.textBoxKorreoa.Text = "Korreo elektronikoa";
            // 
            // buttonIrten
            // 
            this.buttonIrten.BackColor = System.Drawing.SystemColors.Desktop;
            this.buttonIrten.FlatAppearance.BorderColor = System.Drawing.Color.Red;
            this.buttonIrten.FlatAppearance.BorderSize = 2;
            this.buttonIrten.FlatStyle = System.Windows.Forms.FlatStyle.Flat;
            this.buttonIrten.Font = new System.Drawing.Font("Nirmala UI", 13.8F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.buttonIrten.ForeColor = System.Drawing.Color.White;
            this.buttonIrten.Location = new System.Drawing.Point(524, 391);
            this.buttonIrten.Margin = new System.Windows.Forms.Padding(4, 4, 4, 4);
            this.buttonIrten.Name = "buttonIrten";
            this.buttonIrten.Size = new System.Drawing.Size(156, 48);
            this.buttonIrten.TabIndex = 5;
            this.buttonIrten.Text = "IRTEN";
            this.buttonIrten.UseVisualStyleBackColor = false;
            this.buttonIrten.Click += new System.EventHandler(this.ButtonIrten_Click);
            // 
            // HasieraPantailaForm
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(8F, 16F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.BackColor = System.Drawing.SystemColors.InfoText;
            this.ClientSize = new System.Drawing.Size(1067, 554);
            this.Controls.Add(this.buttonIrten);
            this.Controls.Add(this.textBoxKorreoa);
            this.Controls.Add(this.buttonSubmitLogin);
            this.Controls.Add(this.textBoxPasahitza);
            this.Controls.Add(this.label1);
            this.FormBorderStyle = System.Windows.Forms.FormBorderStyle.None;
            this.Icon = ((System.Drawing.Icon)(resources.GetObject("$this.Icon")));
            this.Margin = new System.Windows.Forms.Padding(4, 4, 4, 4);
            this.Name = "HasieraPantailaForm";
            this.StartPosition = System.Windows.Forms.FormStartPosition.CenterScreen;
            this.Text = "LOGIN";
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.Label label1;
        private System.Windows.Forms.TextBox textBoxPasahitza;
        private System.Windows.Forms.Button buttonSubmitLogin;
        private System.Windows.Forms.TextBox textBoxKorreoa;
        private System.Windows.Forms.Button buttonIrten;
    }
}

