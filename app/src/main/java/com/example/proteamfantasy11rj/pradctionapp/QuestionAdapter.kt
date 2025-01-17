package com.example.proteamfantasy11rj.pradctionapp




    import android.view.LayoutInflater
    import android.view.View
    import android.view.ViewGroup
    import android.widget.Button
    import android.widget.TextView
    import androidx.recyclerview.widget.RecyclerView
    import com.google.firebase.database.DatabaseReference
    import com.google.firebase.database.FirebaseDatabase

    class QuestionAdapter(private val questions: List<Question>, private val questionIds: List<String>) :
        RecyclerView.Adapter<QuestionAdapter.QuestionViewHolder>() {

        private val database: DatabaseReference = FirebaseDatabase.getInstance().getReference("questions")

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QuestionViewHolder {
            val view = LayoutInflater.from(parent.context).inflate(R.layout.item_question, parent, false)
            return QuestionViewHolder(view)
        }

        override fun onBindViewHolder(holder: QuestionViewHolder, position: Int) {
            val question = questions[position]
            val questionId = questionIds[position]

            holder.tvQuestion.text = question.question
            holder.updateUI(question.yes, question.no)

            holder.btnYes.setOnClickListener {
                updateAnswer(questionId, "yes")
            }

            holder.btnNo.setOnClickListener {
                updateAnswer(questionId, "no")
            }
        }

        override fun getItemCount(): Int = questions.size

        private fun updateAnswer(questionId: String, answer: String) {
            database.child(questionId).child(answer).get().addOnSuccessListener {
                val currentValue = it.getValue(Int::class.java) ?: 0
                database.child(questionId).child(answer).setValue(currentValue + 1)
            }
        }

        class QuestionViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
            val tvQuestion: TextView = itemView.findViewById(R.id.tvQuestion)
            val tvPercentage: TextView = itemView.findViewById(R.id.tvPercentage)
            val yesBar: View = itemView.findViewById(R.id.yesBar)
            val noBar: View = itemView.findViewById(R.id.noBar)
            val btnYes: Button = itemView.findViewById(R.id.btnYes)
            val btnNo: Button = itemView.findViewById(R.id.btnNo)

            fun updateUI(yesCount: Int, noCount: Int) {
                val total = yesCount + noCount
                val yesPercentage = if (total > 0) (yesCount * 100 / total) else 0
                val noPercentage = 100 - yesPercentage

                tvPercentage.text = "Yes: $yesPercentage% | No: $noPercentage%"
                yesBar.layoutParams.width = (yesPercentage * itemView.resources.displayMetrics.widthPixels / 100)
                noBar.layoutParams.width = (noPercentage * itemView.resources.displayMetrics.widthPixels / 100)
            }
        }
    }

