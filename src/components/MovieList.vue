<template>
    <li>   
        <!-- <button @click="toggleDetails">Show Details</button> -->
        <ul v-if="detailsVisible">
            <li>
                <strong>Phim: </strong> 
                {{name}}
            </li>
            <li>
                <strong>Quốc Gia: </strong> 
                {{country}}
            </li>
            <li>
                <strong>Năm sản xuất: </strong>
                {{year}}
            </li>
            <li>
                <strong>Thể loại: </strong>
                {{casting}}
            </li>
        </ul>
    </li>
</template>


<script>

export default {
    name:'MovieList',
    props: [
        'name',
        'country',
        'year',
        'casting'
    ],
    data() {
        return {
            detailsVisible: true
        }     
    },
    methods: {
        toggleDetails() {
            this.detailsVisible = !this.detailsVisible;
        }     
    }
}
</script>
<style scoped>
li {
    list-style: none;
    font-weight: 600;
}

</style>
