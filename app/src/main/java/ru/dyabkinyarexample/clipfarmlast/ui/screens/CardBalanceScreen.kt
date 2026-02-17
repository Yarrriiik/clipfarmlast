package ru.dyabkinyarexample.clipfarmlast.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import ru.dyabkinyarexample.clipfarmlast.R

data class Transaction(
    val icon: String,
    val title: String,
    val type: String,
    val amount: String,
    val color: Color
)

val transactions = listOf(
    Transaction("⚡", "Генерация видео", "Payment", "- 40.99", Color(0xFFFF9500)),
    Transaction("💰", "Пополнение счета", "Deposit", "+ 460.00", Color(0xFF4CAF50)),
    Transaction("🔄", "Изменение сервера", "Payment", "- 4.10", Color(0xFFB39DDB)),
    Transaction("💰", "Пополнение счета", "Deposit", "+ 320.19", Color(0xFF4CAF50))
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CardBalanceScreen(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF0d0d0d))
    ) {
        // Top Bar
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color(0xFF141718))
                .padding(16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            IconButton(onClick = { navController.popBackStack() }) {
                Icon(Icons.Filled.ArrowBack, contentDescription = "Назад", tint = Color.White)
            }
            Text("Cards", fontSize = 16.sp, color = Color.White, fontWeight = FontWeight.Bold)
            Spacer(modifier = Modifier.width(48.dp))
        }

        // Основной контент
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            // Заголовок
            item {
                Text(
                    text = "Мои карты",
                    fontSize = 32.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                )
            }

            // Карточка с изображением (image05_5)
            item {
                Surface(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(220.dp),
                    color = Color(0xFF1a1a1a),
                    shape = RoundedCornerShape(12.dp)
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.image05_5),
                        contentDescription = "Card Balance",
                        modifier = Modifier.fillMaxSize(),
                        contentScale = ContentScale.Crop
                    )
                }
            }

            item {
                Spacer(modifier = Modifier.height(16.dp))
            }

            // Заголовок "Transactions history"
            item {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        "Transactions history",
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.White
                    )
                    Text(
                        "Today",
                        fontSize = 12.sp,
                        color = Color(0xFF888888)
                    )
                }
            }

            item {
                Spacer(modifier = Modifier.height(8.dp))
            }

            // Список транзакций
            items(transactions.size) { index ->
                TransactionItem(transactions[index])
            }

            item {
                Spacer(modifier = Modifier.height(20.dp))
            }
        }
    }
}

@Composable
private fun TransactionItem(transaction: Transaction) {
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .height(72.dp),
        color = Color(0xFF1a1a1a),
        shape = RoundedCornerShape(8.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(12.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            // Иконка с цветом
            Surface(
                modifier = Modifier
                    .size(40.dp),
                color = transaction.color.copy(alpha = 0.2f),
                shape = RoundedCornerShape(6.dp)
            ) {
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    Text(transaction.icon, fontSize = 20.sp)
                }
            }

            // Информация о транзакции
            Column(
                modifier = Modifier.weight(1f),
                verticalArrangement = Arrangement.spacedBy(4.dp)
            ) {
                Text(
                    transaction.title,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                )
                Text(
                    transaction.type,
                    fontSize = 12.sp,
                    color = Color(0xFF888888)
                )
            }

            // Сумма
            Text(
                transaction.amount,
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold,
                color = transaction.color
            )
        }
    }
}
