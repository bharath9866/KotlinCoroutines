package com.kotlincoroutines.home.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.expandVertically
import androidx.compose.animation.shrinkVertically
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.key
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.kotlincoroutines.home.model.SubTopic

@Composable
fun ExpandCard(
    modifier: Modifier = Modifier,
    icon: String,
    title: String,
    topicsCount: Int,
    subTopics: ArrayList<SubTopic>
) {
    var expanded by remember { mutableStateOf(false) }
    val rotation by animateFloatAsState(
        targetValue = if (expanded) 90f else 0f, label = "rotation"
    )
    Card(
        modifier = modifier
            .clip(RoundedCornerShape(8.dp))
            .border(1.dp, Color(0xFFe5e7eb), RoundedCornerShape(8.dp))
            .background(Color(0xFFe5e7eb))
            .fillMaxWidth(),
        colors = CardDefaults.cardColors(
            containerColor = Color(0xFFf9fafb)
        )
    ) {
        Row(
            modifier = Modifier.clickable { expanded = !expanded }.padding(16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Text(
                text = icon,
                fontWeight = FontWeight.ExtraBold,
                fontSize = 20.sp,
            )
            Column(
                modifier = Modifier.weight(1f),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Text(
                    text = title,
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 18.sp,
                    color = Color(0xFF111827)
                )
                Text(
                    text = "$topicsCount SubTopics",
                    fontWeight = FontWeight.Normal,
                    fontSize = 16.sp,
                    color = Color(0xFF6b7280)
                )
            }
            Image(
                imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight,
                contentDescription = if (expanded) "Collapse" else "Expand",
                modifier = Modifier.size(28.dp).rotate(rotation),
                colorFilter = ColorFilter.tint(Color(0xFF9ca3af))
            )
        }
        HorizontalDivider(thickness = 1.dp, color = Color(0xFFe5e7eb))
        AnimatedVisibility(
            visible = expanded,
            enter = expandVertically(),
            exit = shrinkVertically()
        ) {
            ListOfSubTopicCard(list = subTopics)
        }
    }
}

//@Preview(showBackground = true)
@Composable
fun ListOfSubTopicCard(modifier: Modifier = Modifier, list: ArrayList<SubTopic> = arrayListOf()) {
    Column(modifier = modifier) {
        list.forEach {
            SubTopicCard(text = it.subTopic)
        }
    }
}

@Composable
fun SubTopicCard(modifier: Modifier = Modifier, text: String) {
    Column {
        HorizontalDivider(thickness = 0.5.dp, color = Color(0xFFe5e7eb))
        Row(
            modifier = modifier
                .fillMaxWidth()
                .padding(10.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Box(
                modifier = Modifier
                    .clip(CircleShape)
                    .size(18.dp)
                    .border(2.dp, Color(0xFF9ca3af), CircleShape)
                    .background(Color(0xFFf9fafb), CircleShape)
            )
            Text(
                text = text,
                fontWeight = FontWeight.Normal,
                fontSize = 18.sp,
                color = Color(0xFF374151)
            )
        }
    }
}

@Preview(
    showBackground = true, backgroundColor = 0xFF03FF09,
    device = "spec:width=673dp,height=841dp"
)
@Composable
private fun ExpandCardPreview() {
    ExpandCard(
        modifier = Modifier.padding(16.dp),
        icon = "🚀",
        title = "Coroutine Basics",
        topicsCount = 10,
        subTopics = arrayListOf()
    )
}